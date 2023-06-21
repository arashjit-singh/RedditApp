package com.android.redditapp.domain

import com.android.redditapp.util.NetworkListingPostType

data class RedditModel(
    val id: String,
    val name: String,
    val title: String,
    val score: Int,
    val author: String,
    val subreddit: String,
    val commentCount: Int,
    val created: Long,
    val thumbnail: String?,
    val url: String?,
    val authorFullName: String?,
    val subRedditNamePrefixed: String,
    val postType: NetworkListingPostType,
    val previewUrl: String?,
    val content: String?
)
