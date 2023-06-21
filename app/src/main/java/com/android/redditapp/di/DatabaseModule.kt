package com.android.redditapp.di

import android.content.Context
import androidx.room.Room
import com.android.redditapp.data.local.RedditDatabase
import com.android.redditapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RedditDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = RedditDatabase::class.java,
            name = Constants.DATABASE_NAME
        ).build()
    }

}