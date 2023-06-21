package com.android.redditapp.data.remote.dto.image

import com.google.gson.annotations.SerializedName

data class NetworkPostImageSource(
    @SerializedName("url") val url: String?
)
