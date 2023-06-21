package com.android.redditapp.domain

data class RedditModel(
    val name: String,
    val title: String,
    val score: Int,
    val author: String,
    val subreddit: String,
    val num_comments: Int,
    val created: Long,
    val thumbnail: String?,
    val url: String?,
    val author_fullname: String,
)