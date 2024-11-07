package com.example.android.roomwordssample;

import java.lang.System;

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
 *   existing records with the same value.
 * - `deleteAll()` deletes all rows from the `word_table`.
 *
 * Room automatically handles the conversion of entities to database rows and vice versa.
 *
 * For more details about using DAOs and SQL in Room, refer to the documentation:
 * https://developer.android.com/topic/libraries/architecture/room.html
 */
@androidx.room.Dao
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/android/roomwordssample/WordDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlphabetizedWords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/android/roomwordssample/Word;", "insert", "word", "(Lcom/example/android/roomwordssample/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface WordDao {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM word_table ORDER BY word ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.android.roomwordssample.Word>> getAlphabetizedWords();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.example.android.roomwordssample.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM word_table")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}