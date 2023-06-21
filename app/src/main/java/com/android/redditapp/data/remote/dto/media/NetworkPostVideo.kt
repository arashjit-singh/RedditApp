package com.android.redditapp.data.remote.dto.media

import com.google.gson.annotations.SerializedName

data class NetworkPostVideo(
    @SerializedName("is_gif") val isGif: Boolean?,
    @SerializedName("fallback_url")
    val videoUrl: String?
)
