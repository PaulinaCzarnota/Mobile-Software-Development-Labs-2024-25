/*
 * Modified by Paulina Czarnota.
*/

package com.example.android.roomwordssample

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

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

/**
 * This class contains unit tests for the WordDao to verify the correctness of database operations
 * such as inserting, retrieving, and deleting words.
 *
 * These tests help ensure that Room database operations are working correctly before adding UI components.
 */

@RunWith(AndroidJUnit4::class)
class WordDaoTest {

    // Declare the DAO and the in-memory database
    private lateinit var wordDao: WordDao
    private lateinit var db: WordRoomDatabase

    /**
     * Sets up the in-memory database before each test.
     *
     * The in-memory database is used for testing because it doesn't persist data beyond the test
     * run, ensuring that each test starts with a clean state.
     */
    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()

        // Initialize the in-memory database. Since it's in-memory, data will not persist
        // once the app is killed or the process is terminated.
        db = Room.inMemoryDatabaseBuilder(context, WordRoomDatabase::class.java)
            // Allow queries to be run on the main thread during testing
            .allowMainThreadQueries()
            .build()

        // Get an instance of the WordDao for interacting with the database
        wordDao = db.wordDao()
    }

    /**
     * Closes the database after each test to free up resources.
     */
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    /**
     * Tests inserting and retrieving a single word from the database.
     *
     * The test ensures that after inserting a word, it can be retrieved and matches the inserted value.
     */
    @Test
    @Throws(Exception::class)
    fun insertAndGetWord() = runBlocking {
        // Create a new word object to insert
        val word = Word("word")

        // Insert the word into the database
        wordDao.insert(word)

        // Retrieve the list of all words, sorted alphabetically, from the database
        val allWords = wordDao.getAlphabetizedWords().first()

        // Assert that the first word in the list matches the inserted word
        assertEquals(allWords[0].word, word.word)
    }

    /**
     * Tests inserting and retrieving multiple words.
     *
     * This test inserts two words into the database and ensures that both words are retrieved
     * and sorted in alphabetical order.
     */
    @Test
    @Throws(Exception::class)
    fun getAllWords() = runBlocking {
        // Insert two words into the database
        val word1 = Word("aaa")
        wordDao.insert(word1)
        val word2 = Word("bbb")
        wordDao.insert(word2)

        // Retrieve all words, sorted alphabetically
        val allWords = wordDao.getAlphabetizedWords().first()

        // Assert that the words are ordered correctly (alphabetically)
        assertEquals(allWords[0].word, word1.word)
        assertEquals(allWords[1].word, word2.word)
    }

    /**
     * Tests the deletion of all words from the database.
     *
     * This test ensures that calling `deleteAll()` removes all words from the database,
     * and that after deletion, no words remain in the database.
     */
    @Test
    @Throws(Exception::class)
    fun deleteAll() = runBlocking {
        // Insert two words into the database
        val word1 = Word("word")
        wordDao.insert(word1)
        val word2 = Word("word2")
        wordDao.insert(word2)

        // Delete all words from the database
        wordDao.deleteAll()

        // Retrieve all words from the database (should be empty)
        val allWords = wordDao.getAlphabetizedWords().first()

        // Assert that no words remain in the database after deletion
        assertTrue(allWords.isEmpty())
    }
}