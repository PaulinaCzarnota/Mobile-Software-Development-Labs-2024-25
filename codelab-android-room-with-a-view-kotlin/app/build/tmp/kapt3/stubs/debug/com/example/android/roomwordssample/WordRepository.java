package com.example.android.roomwordssample;

import java.lang.System;

/**
 * This class abstracts access to the data layer by providing methods for interacting with the database.
 * It acts as a repository between the UI and the data source (Room database).
 *
 * As per the Architecture Guide (https://developer.android.com/topic/libraries/architecture/guide.html),
 * the Repository pattern is used to separate the data management from the UI logic.
 * It handles data operations, whether they come from a local database or a network source.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/example/android/roomwordssample/WordRepository;", "", "wordDao", "Lcom/example/android/roomwordssample/WordDao;", "(Lcom/example/android/roomwordssample/WordDao;)V", "allWords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/android/roomwordssample/Word;", "getAllWords", "()Lkotlinx/coroutines/flow/Flow;", "insert", "", "word", "(Lcom/example/android/roomwordssample/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WordRepository {
    private final com.example.android.roomwordssample.WordDao wordDao = null;
    
    /**
     * A Flow object that provides a stream of the word data.
     * Room automatically updates this Flow whenever the data changes, making it easy to observe the changes
     * in the UI in a reactive way.
     */
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.android.roomwordssample.Word>> allWords = null;
    
    public WordRepository(@org.jetbrains.annotations.NotNull
    com.example.android.roomwordssample.WordDao wordDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.android.roomwordssample.Word>> getAllWords() {
        return null;
    }
    
    /**
     * Inserts a new word into the database. This is a suspend function, which means it runs asynchronously
     * and does not block the main thread.
     * The `@WorkerThread` annotation indicates that this function should run on a background thread,
     * which is handled automatically by Room as all suspend functions are off the main thread.
     *
     * @param word The word to be inserted into the database.
     */
    @org.jetbrains.annotations.Nullable
    @androidx.annotation.WorkerThread
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.example.android.roomwordssample.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}