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

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * This is the Data Access Object (DAO) for the Word entity.
 * A DAO is used to interact with the database. In Room, methods in the DAO
 * map directly to SQL queries.
 *
 * @Dao annotation marks this interface as a DAO. Room generates the necessary code
 * to implement this interface at compile time.
 *
 * The methods inside this interface correspond to SQL operations:
 * - `getAlphabetizedWords()` retrieves all words from the `word_table` and orders them alphabetically.
 * - `insert()` inserts a new word into the database, using `OnConflictStrategy.IGNORE` to avoid replacing
 *    existing records with the same value.
 * - `deleteAll()` deletes all rows from the `word_table`.
 *
 * Room automatically handles the conversion of entities to database rows and vice versa.
 *
 * For more details about using DAOs and SQL in Room, refer to the documentation:
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Dao
interface WordDao {

    // Retrieves all words from the "word_table" ordered alphabetically.
    // The result is returned as a Flow to observe updates in real-time.
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    // Inserts a word into the database.
    // If there is a conflict (e.g., the word already exists), it is ignored.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    // Deletes all words from the "word_table".
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}