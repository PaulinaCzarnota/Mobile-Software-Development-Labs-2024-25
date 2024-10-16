package com.example.lab3c

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Private fields of the class
    private var _buttonClickCount: TextView? = null
    private var _button: Button? = null
    private var _clicks: Int = 0
    private var _editText: EditText? = null
    private var _textviewEditText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _buttonClickCount = findViewById(R.id.buttonClickCount)
        _button = findViewById(R.id.button)
        _editText = findViewById(R.id.edittext)
        _textviewEditText = findViewById(R.id.textviewEditText)

        _button?.setOnClickListener {
            _clicks++
            _buttonClickCount?.text = "This button has been clicked $_clicks times"
        }

        _editText?.setOnEditorActionListener { _, actionId, _ ->
            // If the enter button has been clicked on the edit text, then update the textview
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                _textviewEditText?.text = "Entered: ${_editText?.text}"
                // Hide the keyboard
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(_editText?.windowToken, 0)
                true
            } else {
                false // If the event has not been handled then return false
            }
        }
    }
}
