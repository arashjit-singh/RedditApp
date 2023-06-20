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

                val data = db.withTransaction {

                    if (!isConnectedToNetwork) {
                        return@withTransaction db.postDao().getAllPosts()
                    }

                    // clear all tables in the database
                    if (loadType == LoadType.REFRESH) {
                        db.postDao().clearDb()
                    }
                    val childrenList = items?.children
                    val postEntity = childrenList?.map {
                        it.data.toPostEntity()
                    }
                    postEntity?.let { db.postDao().insertPosts(postEntity) }

                    // Load data from the database
                    db.postDao().getAllPosts()
                }

                LoadResult.Page(
                    data = data, prevKey = items.before, nextKey = items.after
                )
            }

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}