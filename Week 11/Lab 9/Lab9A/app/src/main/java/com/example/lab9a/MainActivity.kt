package com.example.lab9a

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    // Constants for the notification channel and notification ID
    private val channelId = "example_channel_id" // Unique identifier for the notification channel
    private val notificationId = 1 // Unique identifier for the notification
    private val requestCode = 1001 // Request code for the POST_NOTIFICATIONS permission

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the "Trigger Notification" button in the layout
        val notifyButton: Button = findViewById(R.id.notifyButton)
        notifyButton.setOnClickListener {
            // Check if the app has permission to post notifications (required for Android 13+)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
            ) {
                // Request the POST_NOTIFICATIONS permission if not granted
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    requestCode
                )
            } else {
                // Trigger the notification if permission is already granted
                triggerNotification()
            }
        }

        // Create the notification channel for devices running Android 8.0 (API 26) or higher
        createNotificationChannel()
    }

    /**
     * Handles the result of the POST_NOTIFICATIONS permission request.
     * If the user grants the permission, the notification is triggered.
     * Otherwise, a toast message informs the user that the permission is denied.
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == this.requestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, trigger the notification
                triggerNotification()
            } else {
                // Inform the user that the permission is denied
                Toast.makeText(this, "Permission denied to post notifications", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Creates a notification channel for Android 8.0 (API 26) and higher.
     * Notification channels are required to display notifications on these devices.
     */
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Example Notification Channel" // Name of the channel
            val descriptionText = "This channel is used for example notifications" // Description of the channel
            val importance = NotificationManager.IMPORTANCE_DEFAULT // Importance level for the channel
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }

            // Register the notification channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /**
     * Builds and displays a notification.
     * Checks for the POST_NOTIFICATIONS permission before displaying the notification.
     * Catches and handles any potential SecurityException.
     */
    private fun triggerNotification() {
        try {
            // Ensure the app has the required permission before posting the notification
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
            ) {
                // Inform the user that the notification permission is required
                Toast.makeText(this, "Notification permission is required", Toast.LENGTH_SHORT).show()
                return
            }

            // Build the notification
            val builder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info) // Icon for the notification
                .setContentTitle("Notification Title") // Title of the notification
                .setContentText("This is the content of the notification.") // Content/body of the notification
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Priority level for devices below Android 8.0

            // Display the notification using NotificationManagerCompat
            with(NotificationManagerCompat.from(this)) {
                notify(notificationId, builder.build()) // Post the notification
            }
        } catch (e: SecurityException) {
            // Handle any potential SecurityException gracefully
            Toast.makeText(this, "Unable to post notification: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}