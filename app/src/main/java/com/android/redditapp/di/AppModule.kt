package com.android.redditapp.di

import android.content.Context
import com.android.redditapp.util.ConnectivityHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConnectivityHelper(@ApplicationContext context: Context): ConnectivityHelper {
        return ConnectivityHelper(context)
    }
}