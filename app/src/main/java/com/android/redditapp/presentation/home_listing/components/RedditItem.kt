package com.android.redditapp.presentation.home_listing.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.redditapp.domain.RedditModel
import com.android.redditapp.presentation.home_listing.components.body.RedditBody
import com.android.redditapp.presentation.home_listing.components.footer.RedditFooter
import com.android.redditapp.presentation.home_listing.components.header.RedditHeader
import com.android.redditapp.presentation.home_listing.components.utils.BottomShadow

@Composable
fun RedditItem(item: RedditModel, openPosHandler: (String, String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        RedditHeader(
            item.thumbnail,
            item.subRedditNamePrefixed,
            item.authorFullName ?: "",
            item.created
        )

        RedditBody(item, openPosHandler = {
            openPosHandler(item.subRedditNamePrefixed, item.id)
        })

        RedditFooter(
            item.score.toString(),
            item.commentCount.toString()
        )

        BottomShadow(alpha = .15f, height = 8.dp)
    }

}

