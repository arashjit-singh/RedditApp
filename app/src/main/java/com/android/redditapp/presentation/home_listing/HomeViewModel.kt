package com.android.redditapp.presentation.home_listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.android.redditapp.data.mapper.toPostModel
import com.android.redditapp.data.repository.RedditRepositoryImpl
import com.android.redditapp.util.AppHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    redditRepository: RedditRepositoryImpl,
    private val appHelper: AppHelper
) : ViewModel() {

    val items = redditRepository.getPopularPagingData("doodoofard").map { postEntity ->
        postEntity.map {
            it.toPostModel()
        }
    }.cachedIn(viewModelScope)

    fun openApp(subredditName: String, id: String) {
        appHelper.openPostOnSubreddit(subredditName, id)
    }

}