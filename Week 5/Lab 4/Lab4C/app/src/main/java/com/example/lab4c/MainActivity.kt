package com.example.lab4c

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    // Declare the variables
    private lateinit var defaultButton: Button
    private lateinit var actionButton: Button
    private lateinit var linearLayout: LinearLayout
    private lateinit var calendarView: CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views using findViewById
        defaultButton = findViewById(R.id.default_button)
        actionButton = findViewById(R.id.action_button)
        linearLayout = findViewById(R.id.linear_layout)
        calendarView = findViewById(R.id.calendarView)

        // Set the minimum and maximum dates for the CalendarView
        val calendar = Calendar.getInstance()

        // Set minimum date: 01/09/2024
        calendar.set(2024, Calendar.SEPTEMBER, 1)
        calendarView.minDate = calendar.timeInMillis

        // Set maximum date: 15/12/2024
        calendar.set(2024, Calendar.DECEMBER, 15)
        calendarView.maxDate = calendar.timeInMillis

        // Default Snackbar action (simple message)
        defaultButton.setOnClickListener {
            val snackbar = Snackbar.make(linearLayout, "This is a simple Snackbar", Snackbar.LENGTH_SHORT)
            snackbar.show()
        }

        // Snackbar with action
        actionButton.setOnClickListener {
            val snackbar = Snackbar.make(
                linearLayout,
                "This is a Snackbar with action",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("DISMISS") {
                snackbar.dismiss()
            }
            snackbar.show()
        }

        // CalendarView onDateChangeListener to show Snackbar with selected date
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            // Format the selected date to "YYYY-MM-DD" (uppercase year)
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, dayOfMonth)

            // Format the date for YYYY-MM-DD (uppercase year)
            val isoFormat = SimpleDateFormat("YYYY-MM-dd", Locale.getDefault()) // Note: use uppercase YYYY
            val formattedIsoDate = isoFormat.format(selectedDate.time)

            // Display Snackbar with the selected date in the desired format
            val snackbar = Snackbar.make(
                linearLayout,
                "Selected date (YYYY-MM-DD): $formattedIsoDate",
                Snackbar.LENGTH_SHORT
            )
            snackbar.show()
        }
    }
}
