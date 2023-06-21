package com.android.redditapp.util

sealed class NetworkListingPostType(private val type: String) {
    object IMAGE : NetworkListingPostType("image")
    object LINK : NetworkListingPostType("link")
    object HOSTED_VIDEO : NetworkListingPostType("hosted:video")
    object RICH_VIDEO : NetworkListingPostType("rich:video")
    object SELF : NetworkListingPostType("self")

    companion object {
        private val values = listOf(IMAGE, LINK, HOSTED_VIDEO, RICH_VIDEO, SELF)
        fun of(value: String): NetworkListingPostType =
            values.firstOrNull { it.type == value } ?: SELF
    }
}


