package com.android.redditapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.redditapp.data.local.PostEntity
import com.android.redditapp.data.local.RedditDatabase
import com.android.redditapp.data.remote.RedditApi
import com.android.redditapp.di.IoDispatcher
import com.android.redditapp.util.ConnectivityHelper
import com.android.redditapp.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RedditRepositoryImpl @Inject constructor(
    private val redditApi: RedditApi,
    private val db: RedditDatabase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val connectivityHelper: ConnectivityHelper
) : RedditRepository {

    override fun getPopularPagingData(subredditName: String): Flow<PagingData<PostEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE,
            ),
            pagingSourceFactory = {
                RedditPagingSource(
                    redditApi = redditApi,
                    db = db,
                    subredditName = subredditName,
                    dispatcher = dispatcher,
                    connectivityHelper = connectivityHelper
                )
            }
        ).flow
    }

}