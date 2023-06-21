package com.android.redditapp.data.repository

import androidx.paging.PagingData
import com.android.redditapp.data.local.PostEntity
import kotlinx.coroutines.flow.Flow

interface RedditRepository {
    fun getPopularPagingData(subredditName: String): Flow<PagingData<PostEntity>>
}