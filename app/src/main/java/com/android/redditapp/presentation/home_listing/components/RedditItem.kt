package com.android.redditapp.presentation.home_listing.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.redditapp.domain.RedditModel
import com.android.redditapp.presentation.home_listing.components.body.RedditBody
import com.android.redditapp.presentation.home_listing.components.footer.RedditFooter
import com.android.redditapp.presentation.home_listing.components.header.RedditHeader

@Composable
fun RedditItem(item: RedditModel, openPosHandler: (String, String) -> Unit) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
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

    }
}