package com.android.redditapp.data.remote.dto.image

import com.google.gson.annotations.SerializedName

data class NetworkPostImagePreview(
    @SerializedName("enabled") val enabled: Boolean?,
    @SerializedName("images") val images: List<NetworkPostImageList>?
)
