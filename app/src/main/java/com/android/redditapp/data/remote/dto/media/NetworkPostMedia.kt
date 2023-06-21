package com.android.redditapp.data.remote.dto.media

import com.google.gson.annotations.SerializedName

data class NetworkPostMedia(
    @SerializedName("reddit_video") val redditVideo: NetworkPostVideo?
)
