package com.android.redditapp.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface RedditDao {
    @Upsert
    suspend fun insertPosts(posts: List<PostEntity>)

    @Query("DELETE FROM postsList")
    suspend fun clearDb()

    @Query("SELECT * from postsList")
    suspend fun getAllPosts(): List<PostEntity>

    @Query("SELECT * from postsList")
    fun getPostSource(): PagingSource<Int, PostEntity>
}