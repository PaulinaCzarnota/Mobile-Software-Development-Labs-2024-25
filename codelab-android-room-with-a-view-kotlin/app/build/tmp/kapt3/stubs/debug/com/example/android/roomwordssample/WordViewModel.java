package com.example.android.roomwordssample;

import java.lang.System;

/**
 * ViewModel to keep a reference to the word repository and
 * provide an up-to-date list of all words.
 *
 * The ViewModel serves as a communication layer between the UI (Activity/Fragment)
 * and the data (Repository). It helps in managing the app's UI-related data in a lifecycle-conscious way.
 * The ViewModel is responsible for managing and preparing the data for the UI,
 * and it also handles business logic, like inserting data into the database in a non-blocking way.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/android/roomwordssample/WordViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/android/roomwordssample/WordRepository;", "(Lcom/example/android/roomwordssample/WordRepository;)V", "allWords", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/android/roomwordssample/Word;", "getAllWords", "()Landroidx/lifecycle/LiveData;", "insert", "Lkotlinx/coroutines/Job;", "word", "app_debug"})
public final class WordViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.android.roomwordssample.WordRepository repository = null;
    
    /**
     * LiveData that holds a list of all words from the repository.
     * - Using LiveData helps in observing changes to the data and ensures that the UI
     *  is updated only when the data changes.
     * - The data is automatically cached, and the observer will only be notified
     *  if the data changes.
     */
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.example.android.roomwordssample.Word>> allWords = null;
    
    public WordViewModel(@org.jetbrains.annotations.NotNull
    com.example.android.roomwordssample.WordRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.example.android.roomwordssample.Word>> getAllWords() {
        return null;
    }
    
    /**
     * Launches a coroutine to insert a new word into the database.
     * This method is called from the UI layer (e.g., an Activity or Fragment) when
     * the user adds a new word.
     *
     * The repository handles the insertion asynchronously to prevent blocking the main thread.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull
    com.example.android.roomwordssample.Word word) {
        return null;
    }
}