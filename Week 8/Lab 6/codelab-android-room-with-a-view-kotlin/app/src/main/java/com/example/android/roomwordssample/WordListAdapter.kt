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

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.WordListAdapter.WordViewHolder

/**
 * This is the adapter for displaying a list of words in a RecyclerView.
 * It uses ListAdapter, which provides built-in support for efficient list updates.
 */
class WordListAdapter : ListAdapter<Word, WordViewHolder>(WORDS_COMPARATOR) {

    /**
     * Creates a new WordViewHolder for each item in the list.
     * This method is called when a new item needs to be created.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    /**
     * Binds data to a ViewHolder.
     * This method is called when an item in the list is about to be displayed.
     */
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position) // Get the current word at the specified position
        holder.bind(current.word)       // Bind the word data to the ViewHolder
    }

    /**
     * ViewHolder class to represent each item in the list.
     * It holds a reference to the view that represents a single word.
     */
    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)

        /**
         * Binds the text (word) to the TextView in the ViewHolder.
         */
        fun bind(text: String?) {
            wordItemView.text = text
        }

        companion object {
            /**
             * Creates a new WordViewHolder with the view inflated from the layout.
             */
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    /**
     * Companion object holding the DiffUtil callback to optimize list updates.
     * It helps Room keep the list in sync with the database by minimizing UI updates.
     */
    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Word>() {
            /**
             * Determines whether two items represent the same word.
             * This method is used to optimize performance when comparing list items.
             */
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem === newItem // Checks if both references point to the same object
            }

            /**
             * Determines whether the contents of two items are the same.
             * This is used to check if the word data has changed.
             */
            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem.word == newItem.word // Checks if the word string is the same
            }
        }
    }
}