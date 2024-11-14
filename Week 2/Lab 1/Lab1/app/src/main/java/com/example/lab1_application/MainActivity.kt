package com.example.lab1_application

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Print message to the console
        println("This is a print message in the log")

        // Log messages of different severity levels
        Log.i("Logging App", "This is an information message")
        Log.v("Logging App", "This is a verbose message")
        Log.d("Logging App", "This is a debug message")
        Log.w("Logging App", "This is a warning message")
        Log.e("Logging App", "This is an error message")  // Use 'Log.e' for error logging
        Log.wtf("Logging App", "This is a WTF message")  // Use 'Log.wtf' for 'What The F?' messages
    }
}
