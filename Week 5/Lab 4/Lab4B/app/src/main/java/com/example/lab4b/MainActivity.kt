package com.example.lab4b

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare the variables
    private lateinit var defaultButton: Button
    private lateinit var actionButton: Button
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views using findViewById
        defaultButton = findViewById(R.id.default_button)
        actionButton = findViewById(R.id.action_button)
        linearLayout = findViewById(R.id.linear_layout)

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
    }
}
