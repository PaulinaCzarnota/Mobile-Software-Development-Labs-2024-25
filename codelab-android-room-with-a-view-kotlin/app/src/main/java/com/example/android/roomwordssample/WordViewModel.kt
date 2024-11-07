/*
 * Modified by Paulina Czarnota.
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

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * ViewModel to keep a reference to the word repository and
 * provide an up-to-date list of all words.
 *
 * The ViewModel serves as a communication layer between the UI (Activity/Fragment)
 * and the data (Repository). It helps in managing the app's UI-related data in a lifecycle-conscious way.
 * The ViewModel is responsible for managing and preparing the data for the UI,
 * and it also handles business logic, like inserting data into the database in a non-blocking way.
 */
class WordViewModel(private val repository: WordRepository) : ViewModel() {

    /**
     * LiveData that holds a list of all words from the repository.
     * - Using LiveData helps in observing changes to the data and ensures that the UI
     *   is updated only when the data changes.
     * - The data is automatically cached, and the observer will only be notified
     *   if the data changes.
     */
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /**
     * Launches a coroutine to insert a new word into the database.
     * This method is called from the UI layer (e.g., an Activity or Fragment) when
     * the user adds a new word.
     *
     * The repository handles the insertion asynchronously to prevent blocking the main thread.
     */
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

/**
 * ViewModelProvider.Factory implementation for creating the WordViewModel.
 * This factory ensures that the ViewModel is provided with the necessary repository dependency.
 */
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Ensure the correct ViewModel class is being created
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}