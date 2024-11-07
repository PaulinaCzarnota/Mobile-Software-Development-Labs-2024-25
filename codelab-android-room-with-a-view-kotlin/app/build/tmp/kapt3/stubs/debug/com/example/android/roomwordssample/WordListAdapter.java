package com.example.android.roomwordssample;

import java.lang.System;

/**
 * This is the adapter for displaying a list of words in a RecyclerView.
 * It uses ListAdapter, which provides built-in support for efficient list updates.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/example/android/roomwordssample/WordListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/example/android/roomwordssample/Word;", "Lcom/example/android/roomwordssample/WordListAdapter$WordViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "WordViewHolder", "app_debug"})
public final class WordListAdapter extends androidx.recyclerview.widget.ListAdapter<com.example.android.roomwordssample.Word, com.example.android.roomwordssample.WordListAdapter.WordViewHolder> {
    @org.jetbrains.annotations.NotNull
    public static final com.example.android.roomwordssample.WordListAdapter.Companion Companion = null;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.example.android.roomwordssample.Word> WORDS_COMPARATOR = null;
    
    public WordListAdapter() {
        super(null);
    }
    
    /**
     * Creates a new WordViewHolder for each item in the list.
     * This method is called when a new item needs to be created.
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.android.roomwordssample.WordListAdapter.WordViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    /**
     * Binds data to a ViewHolder.
     * This method is called when an item in the list is about to be displayed.
     */
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.android.roomwordssample.WordListAdapter.WordViewHolder holder, int position) {
    }
    
    /**
     * ViewHolder class to represent each item in the list.
     * It holds a reference to the view that represents a single word.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/android/roomwordssample/WordListAdapter$WordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "wordItemView", "Landroid/widget/TextView;", "bind", "", "text", "", "Companion", "app_debug"})
    public static final class WordViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView wordItemView = null;
        @org.jetbrains.annotations.NotNull
        public static final com.example.android.roomwordssample.WordListAdapter.WordViewHolder.Companion Companion = null;
        
        public WordViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        /**
         * Binds the text (word) to the TextView in the ViewHolder.
         */
        public final void bind(@org.jetbrains.annotations.Nullable
        java.lang.String text) {
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/android/roomwordssample/WordListAdapter$WordViewHolder$Companion;", "", "()V", "create", "Lcom/example/android/roomwordssample/WordListAdapter$WordViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
            
            /**
             * Creates a new WordViewHolder with the view inflated from the layout.
             */
            @org.jetbrains.annotations.NotNull
            public final com.example.android.roomwordssample.WordListAdapter.WordViewHolder create(@org.jetbrains.annotations.NotNull
            android.view.ViewGroup parent) {
                return null;
            }
        }
    }
    
    /**
     * Companion object holding the DiffUtil callback to optimize list updates.
     * It helps Room keep the list in sync with the database by minimizing UI updates.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/android/roomwordssample/WordListAdapter$Companion;", "", "()V", "WORDS_COMPARATOR", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/example/android/roomwordssample/Word;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}