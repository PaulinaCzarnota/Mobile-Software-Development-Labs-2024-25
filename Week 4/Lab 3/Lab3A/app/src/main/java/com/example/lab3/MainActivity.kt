package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the TextView and change its contents
        val tvTextView = findViewById<TextView>(R.id.textview)
        tvTextView.text = ("changed from Kotlin Code")
    }
}
