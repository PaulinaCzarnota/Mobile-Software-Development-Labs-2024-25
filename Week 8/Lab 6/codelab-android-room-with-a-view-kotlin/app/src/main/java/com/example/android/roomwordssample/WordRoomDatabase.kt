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

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This class represents the backend for the application—the Room database.
 * It defines the entities, version, and access methods for the database.
 */
@Database(entities = [Word::class], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    /**
     * This method provides access to the WordDao for interacting with the Word table.
     *
     * @return WordDao instance to interact with the database.
     */
    abstract fun wordDao(): WordDao

    companion object {
        /**
         * Volatile keyword ensures that the INSTANCE variable is always up-to-date across threads.
         * INSTANCE is the singleton database instance.
         */
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        /**
         * This method returns the singleton instance of the database. If the instance already exists,
         * it returns that instance. Otherwise, it creates a new instance.
         *
         * @param context The context used to create the database.
         * @param scope The coroutine scope used for background operations like database population.
         * @return The singleton WordRoomDatabase instance.
         */
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): WordRoomDatabase {
            // If the INSTANCE is not null, return it, otherwise create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database" // Name of the database
                )
                    // If no migration object is provided, this will wipe and rebuild the database on version changes.
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope)) // Add a callback for initial population
                    .build()
                INSTANCE = instance // Cache the instance
                instance // Return the instance
            }
        }

        /**
         * Callback class to populate the database when it's created.
         */
        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database when the database is created.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // If you want to keep the data through app restarts, comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.wordDao()) // Populate database on creation
                    }
                }
            }
        }

        /**
         * This function populates the database with initial data.
         * It is called once during the initial creation of the database.
         *
         * @param wordDao The WordDao used to interact with the Word table.
         */
        suspend fun populateDatabase(wordDao: WordDao) {
            // Start with a clean database every time
            wordDao.deleteAll()

            // Insert sample data into the Word table
            var word = Word("Hello")
            wordDao.insert(word)
            word = Word("World!")
            wordDao.insert(word)
        }
    }
}