package com.android.redditapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "postsList")
data class PostEntity(
    @PrimaryKey
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("subreddit")
    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val subreddit: String,
    @SerializedName("num_comments")
    val num_comments: Int,
    @SerializedName("created_utc")
    val created: Long,
    val thumbnail: String?,
    val url: String?
)
