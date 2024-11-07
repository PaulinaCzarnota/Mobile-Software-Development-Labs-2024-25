/*
 * Modified and maintained by Paulina Czarnota.
 */

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity for entering a new word.
 * The user enters a word in the EditText, and the result is sent back to the calling activity.
 */
class NewWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        // Initialize the EditText for entering a word.
        val editWordView = findViewById<EditText>(R.id.edit_word)

        // Initialize the save button.
        val button = findViewById<Button>(R.id.button_save)

        // Set a click listener on the save button to return the entered word to the calling activity.
        button.setOnClickListener {
            val replyIntent = Intent()

            // Check if the input is empty. If it is, send a canceled result.
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                // Get the word entered by the user.
                val word = editWordView.text.toString()

                // Put the entered word in the Intent as extra data.
                replyIntent.putExtra(EXTRA_REPLY, word)

                // Set the result as OK and pass the word back to the calling activity.
                setResult(Activity.RESULT_OK, replyIntent)
            }

            // Finish this activity and return to the calling activity.
            finish()
        }
    }

    companion object {
        // Define a constant key for the result data (the entered word).
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}