package com.android.redditapp.di

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.redditapp.data.local.PostEntity
import com.android.redditapp.data.local.RedditDatabase
import com.android.redditapp.data.remote.RedditApi
import com.android.redditapp.data.repository.RedditPagingSource
import com.android.redditapp.util.ConnectivityHelper
import com.android.redditapp.util.Constants
import com.healthifyme.di.DefaultDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRedditFlow(
        redditApi: RedditApi,
        db: RedditDatabase,
        @DefaultDispatcher dispatcher: CoroutineDispatcher,
        connectivityHelper: ConnectivityHelper
    ): Flow<PagingData<PostEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE,
            ),
            pagingSourceFactory = {
                RedditPagingSource(
                    redditApi = redditApi,
                    db = db,
                    subredditName = "technology",
                    dispatcher = dispatcher,
                    connectivityHelper = connectivityHelper
                )
            }
        ).flow
    }

}