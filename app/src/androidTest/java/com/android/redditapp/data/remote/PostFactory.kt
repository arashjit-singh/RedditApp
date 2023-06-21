package com.android.redditapp.data.remote

import com.android.redditapp.data.remote.dto.RedditPost
import com.android.redditapp.data.remote.dto.media.NetworkPostMedia
import java.util.concurrent.atomic.AtomicInteger

class PostFactory {
    private val counter = AtomicInteger(0)
    fun createRedditPost(subredditName: String): RedditPost {
        val id = counter.incrementAndGet()
        val post = RedditPost(
            name = "name_$id",
            title = "title $id",
            score = 10,
            author = "author $id",
            commentCount = 0,
            created = System.currentTimeMillis(),
            thumbnail = null,
            subreddit = subredditName,
            url = null,
            id = id.toString(),
            authorFullName = "author $id",
            content = "",
            isSelf = true,
            postHint = "",
            isVideo = false,
            media = null,
            preview = null,
            subRedditNamePrefixed = "/r/${subredditName}"

        )
        return post
    }
}