package com.example.lab9b

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // SensorManager to access device sensors
    private lateinit var sensorManager: SensorManager

    // References to sensors
    private var temperatureSensor: Sensor? = null
    private var proximitySensor: Sensor? = null
    private var lightSensor: Sensor? = null
    private var pressureSensor: Sensor? = null

    // TextViews to display sensor values
    private lateinit var temperatureTextView: TextView
    private lateinit var proximityTextView: TextView
    private lateinit var lightTextView: TextView
    private lateinit var pressureTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize TextView references
        temperatureTextView = findViewById(R.id.temperature)
        proximityTextView = findViewById(R.id.proximity)
        lightTextView = findViewById(R.id.light)
        pressureTextView = findViewById(R.id.pressure)

        // Initialize SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        // Get references to sensors
        temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
    }

    override fun onResume() {
        super.onResume()
        // Register listeners for sensors
        addSensorListener(temperatureSensor, "Temperature Sensor", temperatureTextView, "°C")
        addSensorListener(proximitySensor, "Proximity Sensor", proximityTextView, "cm")
        addSensorListener(lightSensor, "Light Sensor", lightTextView, "lux")
        addSensorListener(pressureSensor, "Pressure Sensor", pressureTextView, "mbar")
    }

    override fun onPause() {
        super.onPause()
        // Unregister all sensor listeners to save battery
        sensorManager.unregisterListener(sensorListener)
    }

    // SensorEventListener to handle sensor updates
    private val sensorListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                when (it.sensor.type) {
                    Sensor.TYPE_AMBIENT_TEMPERATURE -> updateTextView(temperatureTextView, it.values[0], "°C")
                    Sensor.TYPE_PROXIMITY -> updateTextView(proximityTextView, it.values[0], "cm")
                    Sensor.TYPE_LIGHT -> updateTextView(lightTextView, it.values[0], "lux")
                    Sensor.TYPE_PRESSURE -> updateTextView(pressureTextView, it.values[0], "mbar")
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // No action needed for accuracy changes in this example
        }
    }

    // Helper method to add a sensor listener
    private fun addSensorListener(sensor: Sensor?, sensorName: String, textView: TextView, unit: String) {
        if (sensor != null) {
            sensorManager.registerListener(sensorListener, sensor, SensorManager.SENSOR_DELAY_UI)
        } else {
            textView.text = "$sensorName: Not available"
        }
    }

    // Helper method to update TextView with sensor values
    private fun updateTextView(textView: TextView, value: Float, unit: String) {
        textView.text = "${textView.text.split(":")[0]}: $value $unit"
    }
}
