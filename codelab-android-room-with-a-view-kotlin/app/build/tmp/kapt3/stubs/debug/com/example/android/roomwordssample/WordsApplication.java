package com.example.android.roomwordssample;

import java.lang.System;

/**
 * The Application class for this app. It initializes and manages the app-wide data and resources.
 *
 * This class is responsible for setting up and maintaining:
 * 1. A CoroutineScope that is tied to the application lifecycle.
 * 2. The Room database instance.
 * 3. The repository that provides access to the Word data.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/example/android/roomwordssample/WordsApplication;", "Landroid/app/Application;", "()V", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "getApplicationScope", "()Lkotlinx/coroutines/CoroutineScope;", "database", "Lcom/example/android/roomwordssample/WordRoomDatabase;", "getDatabase", "()Lcom/example/android/roomwordssample/WordRoomDatabase;", "database$delegate", "Lkotlin/Lazy;", "repository", "Lcom/example/android/roomwordssample/WordRepository;", "getRepository", "()Lcom/example/android/roomwordssample/WordRepository;", "repository$delegate", "app_debug"})
public final class WordsApplication extends android.app.Application {
    
    /**
     * A CoroutineScope tied to the lifecycle of the application.
     * This scope will be used to launch coroutines that persist through the lifetime of the app.
     * The SupervisorJob ensures that if a child coroutine fails, it doesn't affect the other coroutines in this scope.
     */
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope applicationScope = null;
    
    /**
     * Lazily initialized database instance. The database is only created when it is accessed for the first time.
     * By using lazy initialization, we ensure that the database is only created when needed, rather than at app startup.
     */
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy database$delegate = null;
    
    /**
     * Lazily initialized repository instance. The repository is only created when needed.
     * It provides access to data operations such as inserting and querying the Word data.
     */
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy repository$delegate = null;
    
    public WordsApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineScope getApplicationScope() {
        return null;
    }
    
    /**
     * Lazily initialized database instance. The database is only created when it is accessed for the first time.
     * By using lazy initialization, we ensure that the database is only created when needed, rather than at app startup.
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.android.roomwordssample.WordRoomDatabase getDatabase() {
        return null;
    }
    
    /**
     * Lazily initialized repository instance. The repository is only created when needed.
     * It provides access to data operations such as inserting and querying the Word data.
     */
    @org.jetbrains.annotations.NotNull
    public final com.example.android.roomwordssample.WordRepository getRepository() {
        return null;
    }
}