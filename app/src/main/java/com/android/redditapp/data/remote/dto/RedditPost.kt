package com.android.redditapp.data.remote.dto

import com.android.redditapp.data.remote.dto.image.NetworkPostImagePreview
import com.android.redditapp.data.remote.dto.media.NetworkPostMedia
import com.google.gson.annotations.SerializedName

data class RedditPost
    (
    @SerializedName("name") val id: String,

    @SerializedName("title") val title: String,

    @SerializedName("score") val score: Int,

    @SerializedName("author") val author: String,

    @SerializedName("subreddit") val subreddit: String,

    @SerializedName("num_comments") val commentCount: Int,

    @SerializedName("author_fullname") val authorFullName: String,

    @SerializedName("created_utc") val created: Long,

    val thumbnail: String?,
    val url: String?,

    @SerializedName("subreddit_name_prefixed") val subRedditNamePrefixed: String,

    @SerializedName("post_hint") val postHint: String?,

    @SerializedName("is_video")

    val isVideo: Boolean?,
    @SerializedName("is_self") val isSelf: Boolean?,

    @SerializedName("media") val media: NetworkPostMedia?,

    @SerializedName("preview") val preview: NetworkPostImagePreview?,

    @SerializedName("selftext") val content: String?,

    )
