package com.android.redditapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RedditPost
    (
    @SerializedName("name")
    val name: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("score")
    val score: Int,

    @SerializedName("author")
    val author: String,

    @SerializedName("subreddit")
    val subreddit: String,

    @SerializedName("num_comments")
    val num_comments: Int,

    @SerializedName("author_fullname")
    val author_fullname: String,

    @SerializedName("created_utc")
    val created: Long,
    val thumbnail: String?,
    val url: String?
)
