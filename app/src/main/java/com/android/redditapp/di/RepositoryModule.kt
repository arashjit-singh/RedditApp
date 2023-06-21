package com.android.redditapp.di

import com.android.redditapp.data.local.RedditDatabase
import com.android.redditapp.data.remote.RedditApi
import com.android.redditapp.data.repository.RedditRepository
import com.android.redditapp.data.repository.RedditRepositoryImpl
import com.android.redditapp.util.ConnectivityHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRedditRepository(
        redditApi: RedditApi,
        db: RedditDatabase,
        @IoDispatcher dispatcher: CoroutineDispatcher,
        connectivityHelperImpl: ConnectivityHelperImpl
    ): RedditRepository {
        return RedditRepositoryImpl(redditApi, db, dispatcher, connectivityHelperImpl)
    }
}