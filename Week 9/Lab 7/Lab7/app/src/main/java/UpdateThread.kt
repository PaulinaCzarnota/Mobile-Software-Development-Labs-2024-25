package com.example.lab7

// Custom thread to count from 1 to 20 and update the UI via the handler
class UpdateThread(private val handler: ThreadHandler) : Thread() {

    // The run() method is executed when the thread starts
    override fun run() {
        for (i in 1..20) {  // Count from 1 to 20
            try {
                Thread.sleep(1000) // Pause for 1 second between each count
            } catch (e: InterruptedException) {
                e.printStackTrace() // Handle potential interruption during sleep
            }

            // Create a message with the current count
            val message = handler.obtainMessage()
            message.arg1 = i  // Store the count in the message's arg1 field

            // Send the message to the handler to update the UI
            handler.sendMessage(message)
        }
    }
}