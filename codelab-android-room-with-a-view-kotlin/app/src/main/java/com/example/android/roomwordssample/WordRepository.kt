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

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

/**
 * This class abstracts access to the data layer by providing methods for interacting with the database.
 * It acts as a repository between the UI and the data source (Room database).
 *
 * As per the Architecture Guide (https://developer.android.com/topic/libraries/architecture/guide.html),
 * the Repository pattern is used to separate the data management from the UI logic.
 * It handles data operations, whether they come from a local database or a network source.
 */
class WordRepository(private val wordDao: WordDao) {

    /**
     * A Flow object that provides a stream of the word data.
     * Room automatically updates this Flow whenever the data changes, making it easy to observe the changes
     * in the UI in a reactive way.
     */
    // Room executes all queries on a separate thread. Observed Flow will notify observers when data changes.
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    /**
     * Inserts a new word into the database. This is a suspend function, which means it runs asynchronously
     * and does not block the main thread.
     * The `@WorkerThread` annotation indicates that this function should run on a background thread,
     * which is handled automatically by Room as all suspend functions are off the main thread.
     *
     * @param word The word to be inserted into the database.
     */
    // Room automatically runs suspend queries off the main thread, so we don't need to do anything extra.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word) // Insert the word into the database via the DAO
    }
}