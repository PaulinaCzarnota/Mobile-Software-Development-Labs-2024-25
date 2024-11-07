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

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A basic class representing an entity in a Room database.
 * Each instance of this class represents a row in the database table.
 *
 * @Entity - Annotates this class as an entity for Room database.
 * The table name is specified as "word_table".
 *
 * @PrimaryKey - The primary key annotation indicates the field that uniquely identifies each record.
 * In this case, the "word" field will be used as the primary key.
 *
 * @ColumnInfo - This annotation allows you to specify a custom column name for the database.
 * Here, the name for the "word" field is explicitly set to "word" in the database.
 * If the column name matches the variable name, the annotation is not required.
 *
 * This class will be used by Room to represent a row in the "word_table" table.
 *
 * For more details, check the Room database documentation:
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey @ColumnInfo(name = "word") val word: String // Column "word" in the database
)