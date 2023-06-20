package com.android.redditapp.data.remote

import com.android.redditapp.data.remote.dto.RedditListingResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RedditApi {

    @GET("/r/{subredditName}/top.json")
    fun getTopPosts(
        @Path("subredditName") subredditName: String,
        @Query("limit") limit: Int
    ): List<RedditListingResponseDto>
}