package com.android.redditapp.data.repository

import androidx.paging.LoadType
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.room.withTransaction
import com.android.redditapp.data.local.PostEntity
import com.android.redditapp.data.local.RedditDatabase
import com.android.redditapp.data.mapper.toPostEntity
import com.android.redditapp.data.remote.RedditApi
import com.android.redditapp.data.remote.dto.ListingData
import com.android.redditapp.util.ConnectivityHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RedditPagingSource @Inject constructor(
    private val redditApi: RedditApi,
    private val db: RedditDatabase,
    private val subredditName: String,
    private val dispatcher: CoroutineDispatcher,
    private val connectivityHelper: ConnectivityHelper
) : PagingSource<String, PostEntity>() {
    override fun getRefreshKey(state: PagingState<String, PostEntity>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, PostEntity> {

        val isConnectedToNetwork = connectivityHelper.isNetworkAvailable()

        return try {
            withContext(dispatcher) {
                val loadType = when (params) {
                    is LoadParams.Refresh -> LoadType.REFRESH
                    is LoadParams.Append -> LoadType.APPEND
                    is LoadParams.Prepend -> LoadType.PREPEND
                }

                val items = if (isConnectedToNetwork) {
                    redditApi.getTopPosts(
                        subredditName = subredditName,
                        after = if (params is LoadParams.Append) params.key else null,
                        before = if (params is LoadParams.Prepend) params.key else null,
                        limit = params.loadSize
                    ).data
                } else {
                    ListingData(children = emptyList(), before = null, after = null)
                }

                val posts = if (isConnectedToNetwork) items.children.map {
                    it.data.toPostEntity()
                } else {
                    db.postDao().getAllPosts()
                }

                posts?.let {
                    db.withTransaction {
                        // clear all tables in the database on refresh
                        if (loadType == LoadType.REFRESH) {
                            db.postDao().clearDb()
                        }

                        posts.let { db.postDao().insertPosts(posts) }
                    }
                }

                LoadResult.Page(
                    data = posts.sortedByDescending { it.created },
                    prevKey = items.before,
                    nextKey = items.after
                )
            }

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}

