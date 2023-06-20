package com.android.redditapp.data.local

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class RedditDaoTest {

    lateinit var db: RedditDatabase
    lateinit var dao: RedditDao

    val postList = listOf(
        PostEntity(
            name = "Post",
            title = "dummyPost",
            author = "dummy",
            created = System.currentTimeMillis(),
            num_comments = 123,
            score = 1,
            subreddit = "dummy",
            thumbnail = "dummyUrl",
            url = "dummyUrl"
        )
    )

    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(
            appContext,
            RedditDatabase::class.java
        ).build()
        dao = db.postDao()
    }

    @After
    fun cleanUp() {
        db.close()
    }


    @Test
    fun test_post_insert_in_db() = runTest {
        dao.insertPosts(postList)
        val postListFromDb = dao.getAllPosts()
        Assert.assertEquals(postList.size, postListFromDb.size)
    }

    @Test
    fun test_db_clear() = runTest {
        dao.insertPosts(postList)
        dao.clearDb()
        Assert.assertEquals(dao.getAllPosts().size, 0)
    }
}