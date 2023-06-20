package com.android.redditapp.data.mapper

import com.android.redditapp.data.local.PostEntity
import com.android.redditapp.data.remote.dto.RedditPost

fun RedditPost.toPostEntity(): PostEntity {
    return PostEntity(
        name, title, score, author, subreddit, num_comments, created, thumbnail, url
    )
}

fun PostEntity.toPost(): RedditPost {
    return RedditPost(
        name, title, score, author, subreddit, num_comments, created, thumbnail, url
    )
}