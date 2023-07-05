package com.android.redditapp.di

import android.content.Context
import com.android.redditapp.util.AppHelper
import com.android.redditapp.util.ConnectivityHelper
import com.android.redditapp.util.ConnectivityHelperImpl
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
        return ConnectivityHelperImpl(context)
    }

    @Provides
    @Singleton
    fun provideAppHelper(@ApplicationContext context: Context): AppHelper {
        return AppHelper(context)
    }

}