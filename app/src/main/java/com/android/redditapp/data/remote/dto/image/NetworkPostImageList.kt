package com.android.redditapp.data.remote.dto.image

import com.google.gson.annotations.SerializedName

data class NetworkPostImageList(
    @SerializedName("id") val id: String?,
    @SerializedName("source") val source: NetworkPostImageSource?
)
