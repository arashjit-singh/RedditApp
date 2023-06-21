package com.android.redditapp.data.mapper

import android.text.Html
import com.android.redditapp.data.local.PostEntity
import com.android.redditapp.data.remote.dto.RedditPost
import com.android.redditapp.domain.RedditModel
import com.android.redditapp.util.NetworkListingPostType

fun RedditPost.toPostEntity(): PostEntity {
    return PostEntity(
        id,
        name,
        title,
        score,
        author,
        subreddit,
        commentCount,
        created,
        thumbnail,
        url,
        authorFullName,
        subRedditNamePrefixed,
        postHint,
        isVideo,
        isSelf,
        previewUrl = if (preview?.images?.firstOrNull()?.source?.url?.isNotBlank() == true) Html.escapeHtml(
            preview?.images?.firstOrNull()?.source?.url
        ) else "",
        media = media?.redditVideo?.videoUrl,
        isGif = media?.redditVideo?.isGif,
        content = content
    )
}

fun PostEntity.toPostModel(): RedditModel {
    return RedditModel(
        id,
        name,
        title,
        score,
        author,
        subreddit,
        commentCount,
        created,
        thumbnail,
        url,
        authorFullName,
        subRedditNamePrefixed,
        postType = when {
            postHint != null -> NetworkListingPostType.of(postHint)
            isSelf == true -> NetworkListingPostType.SELF
            isVideo == true && media != null -> NetworkListingPostType.HOSTED_VIDEO
            else -> NetworkListingPostType.SELF
        },
        previewUrl = previewUrl,
        content = content
    )
}