package com.android.redditapp.data.repository

import android.content.Context
import androidx.paging.PagingSource
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.android.redditapp.data.local.RedditDatabase
import com.android.redditapp.data.remote.FakeRedditApi
import com.android.redditapp.data.remote.PostFactory
import com.android.redditapp.util.ConnectivityHelperFake
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RedditPagingSourceTest {

    private lateinit var db: RedditDatabase

    val DEFAULT_SUBREDDIT = "android"

    private val postFactory = PostFactory()
    private val fakePosts = listOf(
        postFactory.createRedditPost(DEFAULT_SUBREDDIT)
    )
    private val fakeApi = FakeRedditApi().apply {
        fakePosts.forEach { post -> addPost(post) }
    }

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, RedditDatabase::class.java
        ).build()
    }

    @Test
    fun test_pageKeyedSubredditPagingSource() = runTest {
        val pagingSource = RedditPagingSource(
            redditApi = fakeApi,
            db = db,
            subredditName = DEFAULT_SUBREDDIT,
            dispatcher = UnconfinedTestDispatcher(),
            connectivityHelperImpl = ConnectivityHelperFake(),
        )

        val actual = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null, loadSize = 2, placeholdersEnabled = false
            )
        )

        val expected = PagingSource.LoadResult.Page(
            data = listOf(fakePosts[0]),
            prevKey = null,
            nextKey = null
        )

        assertEquals((actual as PagingSource.LoadResult.Page)?.data?.size, expected.data.size)
    }

}