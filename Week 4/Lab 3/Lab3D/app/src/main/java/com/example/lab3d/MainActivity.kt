package com.example.lab3d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Private fields of the class
    private var _buttonClickCount: TextView? = null
    private var _button: Button? = null
    private var _clicks: Int = 0
    private var _editText: EditText? = null
    private var _textviewEditText: TextView? = null
    private var _radioGroup: RadioGroup? = null
    private var _radioButtonLabel: TextView? = null
    private var _spinner: Spinner? = null
    private var _fruits = arrayOf("Apple", "Banana", "Cherry", "Date", "Grape")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _buttonClickCount = findViewById(R.id.buttonClickCount)
        _button = findViewById(R.id.button)
        _editText = findViewById(R.id.edittext)
        _textviewEditText = findViewById(R.id.textviewEditText)
        _radioGroup = findViewById(R.id.radioGroup)
        _radioButtonLabel = findViewById(R.id.radioButtonLabel)
        _spinner = findViewById(R.id.spinner)

        // Set up the spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, _fruits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        _spinner?.adapter = adapter

        _button?.setOnClickListener {
            _clicks++
            _buttonClickCount?.text = "This button has been clicked $_clicks times"
        }

        _editText?.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                _textviewEditText?.text = "Entered: ${_editText?.text}"
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(_editText?.windowToken, 0)
                true
            } else {
                false
            }
        }

        _radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            // Update the label with the selected radio button number
            val buttonNumber = radioButton.text.substring(radioButton.text.length - 1) // Get the number from button text
            _radioButtonLabel?.text = "Radio Button $buttonNumber clicked"
        }

        _spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedFruit = _fruits[position]
                findViewById<TextView>(R.id.spinnerLabel)?.text = "The fruit you chose was: $selectedFruit"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }
}
