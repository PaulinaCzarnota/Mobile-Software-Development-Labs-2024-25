package com.example.lab3b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Private fields of the class
    private var _textView: TextView? = null
    private var _button: Button? = null
    private var _clicks: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _textView = findViewById(R.id.textview)
        _button = findViewById(R.id.button)

        _button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                _clicks++
                _textView?.text = "This button has been clicked $_clicks times"
            }
        })
    }
}
