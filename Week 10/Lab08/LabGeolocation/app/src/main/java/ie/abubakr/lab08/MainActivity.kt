package ie.abubakr.lab08

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*

class MainActivity : AppCompatActivity(), LocationListener {

    // UI components
    private lateinit var locationText: TextView // Displays current latitude and longitude
    private lateinit var localityText: TextView // Displays the translated address
    private lateinit var minTimeInput: EditText // Input for minTime
    private lateinit var minDistanceInput: EditText // Input for minDistance
    private lateinit var setButton: Button // Button to update minTime and minDistance
    private lateinit var locationListView: ListView // Displays the list of visited addresses

    // Location services and variables
    private var locationManager: LocationManager? = null // LocationManager to handle GPS updates
    private var minTime: Long = 1000 // Default minimum time (in ms) between updates
    private var minDistance: Float = 1f // Default minimum distance (in meters) between updates
    private val locationList = mutableListOf<String>() // List to store visited addresses
    private lateinit var locationAdapter: ArrayAdapter<String> // Adapter for the ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        locationText = findViewById(R.id.location)
        localityText = findViewById(R.id.locality)
        minTimeInput = findViewById(R.id.min_time_input)
        minDistanceInput = findViewById(R.id.min_distance_input)
        setButton = findViewById(R.id.set_button)
        locationListView = findViewById(R.id.location_list)

        // Initialize adapter and set up the ListView
        locationAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        locationListView.adapter = locationAdapter

        // Set up location services
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        // Handle button click to update minTime and minDistance
        setButton.setOnClickListener {
            val newMinTime = minTimeInput.text.toString().toLongOrNull()
            val newMinDistance = minDistanceInput.text.toString().toFloatOrNull()

            if (newMinTime != null && newMinDistance != null) {
                minTime = newMinTime
                minDistance = newMinDistance
                Toast.makeText(
                    this,
                    "Values updated: minTime = $minTime ms, minDistance = $minDistance m",
                    Toast.LENGTH_SHORT
                ).show()
                startLocationUpdates() // Restart location updates with new values
            } else {
                Toast.makeText(this, "Invalid inputs. Please enter valid numbers.", Toast.LENGTH_SHORT).show()
            }
        }

        // Check for location permission and start updates
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_CODE
            )
        } else {
            startLocationUpdates()
        }
    }

    /**
     * Starts location updates with the current minTime and minDistance settings.
     */
    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            locationManager?.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime,
                minDistance,
                this
            )
        }
    }

    override fun onLocationChanged(location: Location) {
        // Update latitude and longitude on the screen
        val latLng = "Latitude: ${location.latitude}, Longitude: ${location.longitude}"
        locationText.text = "Current Location\n$latLng"
        Log.d("GPSLOCATION", "Location updated: $latLng")

        // Use Geocoder to translate coordinates into an address
        try {
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses: List<Address>? = geocoder.getFromLocation(location.latitude, location.longitude, 1)
            if (addresses != null && addresses.isNotEmpty()) {
                val address = formatAddress(addresses[0])
                localityText.text = address
                addToLocationList(address) // Add the address to the list
            } else {
                localityText.text = "Unable to get address"
            }
        } catch (e: Exception) {
            e.printStackTrace()
            localityText.text = "Error obtaining address"
        }
    }

    /**
     * Formats an Address object into a readable string.
     */
    private fun formatAddress(address: Address): String {
        return listOfNotNull(
            address.featureName,
            address.thoroughfare,
            address.locality,
            address.adminArea,
            address.countryName
        ).joinToString(", ")
    }

    /**
     * Adds a new address to the list and updates the ListView.
     */
    private fun addToLocationList(address: String) {
        locationList.add(0, address) // Add the address at the top of the list
        locationAdapter.notifyDataSetChanged() // Notify the adapter to refresh the ListView
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationUpdates()
            } else {
                Toast.makeText(this, "Permission denied. Cannot get location.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lab08", "Resuming location updates")
        startLocationUpdates()
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lab08", "Pausing location updates")
        locationManager?.removeUpdates(this)
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1001 // Request code for location permission
    }
}