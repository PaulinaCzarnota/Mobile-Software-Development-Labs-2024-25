package com.example.lab7

import android.os.Handler
import android.os.Looper
import android.os.Message

// Custom Handler class to update the UI from a background thread
class ThreadHandler(private val mainActivity: MainActivity) : Handler(Looper.getMainLooper()) {

    // Called when a message is sent to this handler
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)

        // Update the UI with the counter value (msg.arg1)
        mainActivity.updateUI(msg.arg1)
    }
}