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
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1

    // Using viewModels delegate to create an instance of WordViewModel
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView to display the list of words
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter() // Adapter for displaying words
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this) // Layout manager to position items in a vertical list

        // Set up FloatingActionButton to navigate to NewWordActivity to add a new word
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            // Launch NewWordActivity when FAB is clicked
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }

        // Observe the LiveData from the ViewModel. This ensures that when the word list changes,
        // the RecyclerView adapter gets updated with the new list of words.
        wordViewModel.allWords.observe(owner = this) { words ->
            // Update the adapter with the list of words when data changes
            words?.let { adapter.submitList(it) }
        }
    }

    // Handle the result from NewWordActivity when a new word is added
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        // Check if the result is from NewWordActivity and the result is OK
        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            // Extract the word entered in the NewWordActivity and insert it into the database
            intentData?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let { reply ->
                val word = Word(reply)
                wordViewModel.insert(word) // Insert the new word into the database
            }
        } else {
            // If the result is not OK, show a Toast indicating that the word was not saved
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved, // String resource for the message
                Toast.LENGTH_LONG
            ).show()
        }
    }
}