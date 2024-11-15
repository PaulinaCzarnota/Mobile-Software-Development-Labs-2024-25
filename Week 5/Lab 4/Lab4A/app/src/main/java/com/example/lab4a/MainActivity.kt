package com.example.lab4a

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the TextView
        textView = findViewById(R.id.textview)

        // Set the initial text for TextView
        textView.text = "Add menu item selected"

        // Setup Toolbar as ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    // Inflate the menu from the menu.xml resource file
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu items defined in menu.xml
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // Handle menu item selections
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Handle the "First" menu item selection
            R.id.first -> {
                textView.text = "First menu item selected"
                true
            }
            // Handle the "Second" menu item selection
            R.id.second -> {
                textView.text = "Second menu item selected"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
