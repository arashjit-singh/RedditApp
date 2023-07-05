package com.android.redditapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.redditapp.data.local.PostEntity
import com.android.redditapp.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RedditRepositoryImpl @Inject constructor(
    private val redditPagingSource: RedditPagingSource
) : RedditRepository {

    override fun getPopularPagingData(subredditName: String): Flow<PagingData<PostEntity>> {

        redditPagingSource.subredditName = subredditName

        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE,
            ),
            pagingSourceFactory = {
                redditPagingSource
            }
        ).flow
    }

}