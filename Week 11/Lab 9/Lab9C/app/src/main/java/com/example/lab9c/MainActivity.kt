package com.example.lab9c

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    // SensorManager to manage the device's sensors
    private lateinit var sensorManager: SensorManager

    // References to specific sensors
    private var accelerometer: Sensor? = null
    private var gyroscope: Sensor? = null
    private var magneticField: Sensor? = null
    private var gravity: Sensor? = null
    private var linearAcceleration: Sensor? = null

    // TextViews to display sensor data
    private lateinit var accelerometerTextView: TextView
    private lateinit var gyroscopeTextView: TextView
    private lateinit var magneticFieldTextView: TextView
    private lateinit var gravityTextView: TextView
    private lateinit var linearAccelerationTextView: TextView

    // Listener to receive sensor updates
    private val sensorListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                // Update the corresponding TextView based on the sensor type
                when (it.sensor.type) {
                    Sensor.TYPE_ACCELEROMETER -> updateTextView(
                        accelerometerTextView, it.values, "Accelerometer"
                    )
                    Sensor.TYPE_GYROSCOPE -> updateTextView(
                        gyroscopeTextView, it.values, "Gyroscope"
                    )
                    Sensor.TYPE_MAGNETIC_FIELD -> updateTextView(
                        magneticFieldTextView, it.values, "Magnetic Field"
                    )
                    Sensor.TYPE_GRAVITY -> updateTextView(
                        gravityTextView, it.values, "Gravity"
                    )
                    Sensor.TYPE_LINEAR_ACCELERATION -> updateTextView(
                        linearAccelerationTextView, it.values, "Linear Acceleration"
                    )
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // Not used for this example but required by the interface
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the Toolbar as the header for the activity
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize TextViews to display sensor data
        accelerometerTextView = findViewById(R.id.accelerometer)
        gyroscopeTextView = findViewById(R.id.gyroscope)
        magneticFieldTextView = findViewById(R.id.magnetic_field)
        gravityTextView = findViewById(R.id.gravity)
        linearAccelerationTextView = findViewById(R.id.linear)

        // Initialize SensorManager to access device sensors
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        // Retrieve the sensors from the SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        magneticField = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
        gravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        linearAcceleration = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
    }

    override fun onResume() {
        super.onResume()
        // Register listeners for the available sensors
        registerSensorListener(accelerometer)
        registerSensorListener(gyroscope)
        registerSensorListener(magneticField)
        registerSensorListener(gravity)
        registerSensorListener(linearAcceleration)
    }

    override fun onPause() {
        super.onPause()
        // Unregister the listener to save battery and resources
        sensorManager.unregisterListener(sensorListener)
    }

    /**
     * Registers a listener for the specified sensor if it is available.
     */
    private fun registerSensorListener(sensor: Sensor?) {
        sensor?.let {
            sensorManager.registerListener(sensorListener, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    /**
     * Updates the specified TextView with the provided sensor values (X, Y, Z).
     *
     * @param textView The TextView to update
     * @param values   The array of sensor values
     * @param sensorName The name of the sensor
     */
    private fun updateTextView(textView: TextView, values: FloatArray, sensorName: String) {
        val x = values[0]
        val y = values[1]
        val z = values[2]
        textView.text = "$sensorName:\nX: $x\nY: $y\nZ: $z"
    }
}