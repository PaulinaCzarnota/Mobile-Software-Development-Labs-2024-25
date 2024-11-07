package com.example.android.roomwordssample;

import java.lang.System;

/**
 * This class represents the backend for the application—the Room database.
 * It defines the entities, version, and access methods for the database.
 */
@androidx.room.Database(entities = {com.example.android.roomwordssample.Word.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/android/roomwordssample/WordRoomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "wordDao", "Lcom/example/android/roomwordssample/WordDao;", "Companion", "app_debug"})
public abstract class WordRoomDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull
    public static final com.example.android.roomwordssample.WordRoomDatabase.Companion Companion = null;
    
    /**
     * Volatile keyword ensures that the INSTANCE variable is always up-to-date across threads.
     * INSTANCE is the singleton database instance.
     */
    @kotlin.jvm.Volatile
    private static volatile com.example.android.roomwordssample.WordRoomDatabase INSTANCE;
    
    public WordRoomDatabase() {
        super();
    }
    
    /**
     * This method provides access to the WordDao for interacting with the Word table.
     *
     * @return WordDao instance to interact with the database.
     */
    @org.jetbrains.annotations.NotNull
    public abstract com.example.android.roomwordssample.WordDao wordDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/android/roomwordssample/WordRoomDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/android/roomwordssample/WordRoomDatabase;", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "populateDatabase", "", "wordDao", "Lcom/example/android/roomwordssample/WordDao;", "(Lcom/example/android/roomwordssample/WordDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WordDatabaseCallback", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * This method returns the singleton instance of the database. If the instance already exists,
         * it returns that instance. Otherwise, it creates a new instance.
         *
         * @param context The context used to create the database.
         * @param scope The coroutine scope used for background operations like database population.
         * @return The singleton WordRoomDatabase instance.
         */
        @org.jetbrains.annotations.NotNull
        public final com.example.android.roomwordssample.WordRoomDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
        
        /**
         * This function populates the database with initial data.
         * It is called once during the initial creation of the database.
         *
         * @param wordDao The WordDao used to interact with the Word table.
         */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object populateDatabase(@org.jetbrains.annotations.NotNull
        com.example.android.roomwordssample.WordDao wordDao, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return null;
        }
        
        /**
         * Callback class to populate the database when it's created.
         */
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/android/roomwordssample/WordRoomDatabase$Companion$WordDatabaseCallback;", "Landroidx/room/RoomDatabase$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_debug"})
        static final class WordDatabaseCallback extends androidx.room.RoomDatabase.Callback {
            private final kotlinx.coroutines.CoroutineScope scope = null;
            
            public WordDatabaseCallback(@org.jetbrains.annotations.NotNull
            kotlinx.coroutines.CoroutineScope scope) {
                super();
            }
            
            /**
             * Override the onCreate method to populate the database when the database is created.
             */
            @java.lang.Override
            public void onCreate(@org.jetbrains.annotations.NotNull
            androidx.sqlite.db.SupportSQLiteDatabase db) {
            }
        }
    }
}