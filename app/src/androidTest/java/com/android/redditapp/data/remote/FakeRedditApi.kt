package com.android.redditapp.data.remote

import com.android.redditapp.data.remote.dto.ListingData
import com.android.redditapp.data.remote.dto.RedditChildrenResponse
import com.android.redditapp.data.remote.dto.RedditListingResponseDto
import com.android.redditapp.data.remote.dto.RedditPost
import kotlin.math.min

class FakeRedditApi : RedditApi {

    // subreddits keyed by name
    private val model = mutableMapOf<String, SubReddit>()

    fun addPost(post: RedditPost) {
        val subreddit = model.getOrPut(post.subreddit) {
            SubReddit(items = arrayListOf())
        }
        subreddit.items.add(post)
    }

    override suspend fun getTopPosts(
        subreddit: String,
        limit: Int,
        after: String?,
        before: String?
    ): RedditListingResponseDto {

        val items = findPosts(subreddit, limit, after, before)
        val nextAfter = items.lastOrNull()?.data?.name

        return RedditListingResponseDto(
            data = ListingData(
                children = items,
                after = nextAfter,
                before = null
            )
        )

    }

    private fun findPosts(
        subreddit: String,
        limit: Int,
        after: String? = null,
        before: String? = null
    ): List<RedditChildrenResponse> {
        // only support paging forward
        if (before != null) return emptyList()

        val subReddit = findSubReddit(subreddit)
        val posts = subReddit.findPosts(limit, after)
        return posts.map { RedditChildrenResponse(it.copy()) }
    }


    private fun findSubReddit(subreddit: String) =
        model.getOrDefault(subreddit, SubReddit())

    private class SubReddit(val items: MutableList<RedditPost> = arrayListOf()) {
        fun findPosts(limit: Int, after: String?): List<RedditPost> {
            if (after == null) {
                return items.subList(0, min(items.size, limit))
            }
            val index = items.indexOfFirst { it.name == after }
            if (index == -1) {
                return emptyList()
            }
            val startPos = index + 1
            return items.subList(startPos, min(items.size, startPos + limit))
        }
    }
}