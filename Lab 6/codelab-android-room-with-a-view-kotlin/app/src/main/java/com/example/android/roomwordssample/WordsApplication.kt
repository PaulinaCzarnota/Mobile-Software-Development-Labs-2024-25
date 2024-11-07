/*
 * Modified by Paulina Czarnota.
 */

/*
 * Copyright (C) 2020 The Android Open Source Project
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

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * The Application class for this app. It initializes and manages the app-wide data and resources.
 *
 * This class is responsible for setting up and maintaining:
 * 1. A CoroutineScope that is tied to the application lifecycle.
 * 2. The Room database instance.
 * 3. The repository that provides access to the Word data.
 */
class WordsApplication : Application() {

    /**
     * A CoroutineScope tied to the lifecycle of the application.
     * This scope will be used to launch coroutines that persist through the lifetime of the app.
     * The SupervisorJob ensures that if a child coroutine fails, it doesn't affect the other coroutines in this scope.
     */
    val applicationScope = CoroutineScope(SupervisorJob())

    /**
     * Lazily initialized database instance. The database is only created when it is accessed for the first time.
     * By using lazy initialization, we ensure that the database is only created when needed, rather than at app startup.
     */
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }

    /**
     * Lazily initialized repository instance. The repository is only created when needed.
     * It provides access to data operations such as inserting and querying the Word data.
     */
    val repository by lazy { WordRepository(database.wordDao()) }
}