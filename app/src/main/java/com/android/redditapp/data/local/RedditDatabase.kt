package com.android.redditapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class RedditDatabase : RoomDatabase() {
    abstract fun postDao(): RedditDao
}
