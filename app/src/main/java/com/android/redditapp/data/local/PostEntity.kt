package com.android.redditapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "postsList")
data class PostEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val title: String,
    val score: Int,
    val author: String,
    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val subreddit: String,
    val commentCount: Int,
    val created: Long,
    val thumbnail: String?,
    val url: String?,
    val authorFullName: String?,
    val subRedditNamePrefixed: String,
    val postHint: String?,
    val isVideo: Boolean?,
    val isSelf: Boolean?,
    val previewUrl: String?,
    val media: String?,
    val isGif: Boolean?,
    val content: String?
) : Comparable<PostEntity> {
    override fun compareTo(other: PostEntity): Int {
        return created.compareTo(other.created)
    }

}
