package com.example.lab5a

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var headerTextView: TextView // Header for the app
    private lateinit var messageTextView: TextView // TextView to display messages
    private lateinit var alertButton: Button // Button to trigger alert dialog
    private lateinit var listButton: Button // Button to trigger list dialog
    private lateinit var inputButton: Button // Button to trigger input dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        headerTextView = findViewById(R.id.header_textview)
        messageTextView = findViewById(R.id.message_textview)
        alertButton = findViewById(R.id.alert_button)
        listButton = findViewById(R.id.list_button)
        inputButton = findViewById(R.id.input_button)

        // Set up button listeners
        alertButton.setOnClickListener {
            alertDialog() // Show alert dialog on button click
        }

        listButton.setOnClickListener {
            listDialog() // Show list dialog on button click
        }

        inputButton.setOnClickListener {
            inputDialog() // Show input dialog on button click
        }
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog") // Set dialog title
        builder.setMessage("This is an alert dialog") // Set dialog message
        builder.setPositiveButton("Yes") { dialog, _ ->
            messageTextView.text = "Alert dialog was dismissed with Yes" // Update message
            dialog.dismiss() // Dismiss dialog
        }
        builder.setNegativeButton("No") { dialog, _ ->
            messageTextView.text = "Alert dialog was dismissed with No" // Update message
            dialog.dismiss() // Dismiss dialog
        }
        val dialog: AlertDialog = builder.create() // Create dialog
        dialog.show() // Show dialog
    }

    private fun listDialog() {
        val items = resources.getStringArray(R.array.list_items) // Get list items from resources
        val builder = AlertDialog.Builder(this)
        builder.setTitle("List dialog: Choose an option") // Set dialog title
        builder.setItems(items) { dialog, which ->
            messageTextView.text = "You chose: ${items[which]}" // Update message based on selection
        }
        val dialog: AlertDialog = builder.create() // Create dialog
        dialog.show() // Show dialog
    }

    private fun inputDialog() {
        val editText = EditText(this) // Create an EditText for user input
        editText.inputType = InputType.TYPE_CLASS_TEXT // Set input type to text
        editText.hint = "Enter text here" // Default hint text
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Input dialog") // Set dialog title
        builder.setView(editText) // Set the EditText view
        builder.setPositiveButton("Accept") { dialog, _ ->
            messageTextView.text = "Input: ${editText.text}" // Update message with user input
            dialog.dismiss() // Dismiss dialog
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel() // Cancel dialog
        }
        val dialog: AlertDialog = builder.create() // Create dialog
        dialog.show() // Show dialog
    }
}