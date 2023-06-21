package com.android.redditapp.presentation.home_listing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.android.redditapp.domain.RedditModel
import com.android.redditapp.presentation.home_listing.components.RedditItem

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val lazyPagingItems: LazyPagingItems<RedditModel> = viewModel.items.collectAsLazyPagingItems()
    LazyColumn {
        items(
            lazyPagingItems.itemCount
        ) { index ->
            val item = lazyPagingItems[index]
            item?.let {
                RedditItem(item) { subredditName, id ->
                    viewModel.openApp(subredditName, id)
                }
            }
        }

        when (lazyPagingItems.loadState.refresh) { //FIRST LOAD
            is LoadState.Error -> {
                //state.error to get error message
            }

            is LoadState.Loading -> { // Loading UI
                item {
                    CircleLoader(
                        modifier = Modifier.fillParentMaxSize()
                    )
                }
            }

            else -> {}
        }

        when (lazyPagingItems.loadState.append) { // Pagination
            is LoadState.Error -> {
                //state.error to get error message
            }

            is LoadState.Loading -> { // Pagination Loading UI
                item {
                    CircleLoader(
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            else -> {

            }
        }
    }
}

@Composable
fun CircleLoader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(color = Color.Blue)
    }
}