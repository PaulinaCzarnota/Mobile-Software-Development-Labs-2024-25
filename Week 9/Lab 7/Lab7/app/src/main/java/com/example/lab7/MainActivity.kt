package com.example.lab7

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    // Views for displaying text and counter
    private lateinit var displayTextView: TextView
    private lateinit var counterTextView: TextView

    // Handler and Executor for background tasks
    private val handler = ThreadHandler(this)
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize TextViews
        displayTextView = findViewById(R.id.displayTextView)
        counterTextView = findViewById(R.id.counterTextView)
    }

    // Change content on button click
    fun genContent(view: View) {
        displayTextView.text = "Hello, Android!"  // Update display text
    }

    // Start counter in background
    fun runDelay(view: View) {
        executorService.execute(UpdateThread(handler))  // Run background task
    }

    // Update counter in UI
    fun updateUI(counter: Int) {
        counterTextView.text = "Counter: $counter"  // Update counter display
    }
}