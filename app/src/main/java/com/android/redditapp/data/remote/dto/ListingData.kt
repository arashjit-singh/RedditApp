package com.android.redditapp.data.remote.dto

data class ListingData(
    val children: List<RedditChildrenResponse>, val after: String?, val before: String?
)
