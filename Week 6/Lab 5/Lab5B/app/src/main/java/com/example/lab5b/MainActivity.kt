package com.example.lab5b

import android.content.res.Configuration
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var headerTextView: TextView
    private lateinit var messageTextView: TextView
    private lateinit var alertButton: Button
    private lateinit var listButton: Button
    private lateinit var inputButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Determine the current orientation and set the appropriate layout
        val config: Configuration = resources.configuration
        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main) // Portrait layout
        } else if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_horizontal) // Landscape layout
        }

        // Initialize views
        headerTextView = findViewById(R.id.header_textview)
        messageTextView = findViewById(R.id.message_textview)
        alertButton = findViewById(R.id.alert_button)
        listButton = findViewById(R.id.list_button)
        inputButton = findViewById(R.id.input_button)

        // Set up button listeners
        alertButton.setOnClickListener { alertDialog() }
        listButton.setOnClickListener { listDialog() }
        inputButton.setOnClickListener { inputDialog() }
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog")
        builder.setMessage("This is an alert dialog")
        builder.setPositiveButton("Yes") { dialog, _ ->
            messageTextView.text = "Alert dialog was dismissed with Yes"
            dialog.dismiss()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            messageTextView.text = "Alert dialog was dismissed with No"
            dialog.dismiss()
        }
        builder.create().show()
    }

    private fun listDialog() {
        val items = resources.getStringArray(R.array.list_items)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("List dialog: Choose an option")
        builder.setItems(items) { dialog, which ->
            messageTextView.text = "You chose: ${items[which]}"
        }
        builder.create().show()
    }

    private fun inputDialog() {
        val editText = EditText(this)
        editText.inputType = InputType.TYPE_CLASS_TEXT
        editText.hint = "Enter text here"
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Input dialog")
        builder.setView(editText)
        builder.setPositiveButton("Accept") { dialog, _ ->
            messageTextView.text = "Input: ${editText.text}"
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
        builder.create().show()
    }
}
