package com.android.redditapp.presentation.home_listing.components.body

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android.redditapp.R
import com.android.redditapp.domain.RedditModel
import com.android.redditapp.util.NetworkListingPostType

@Composable
fun RedditBody(
    post: RedditModel, openPosHandler: () -> Unit, modifier: Modifier = Modifier
) {

    when (post.postType) {
        NetworkListingPostType.IMAGE -> {
            ItemBodyImageView(title = post.title, image = post.url, onPostClickCallback = {
                openPosHandler()
            })
        }

        NetworkListingPostType.SELF -> {
            ItemBodySelfView(title = post.title, content = post.content, onPostClickCallback = {
                openPosHandler()
            })
        }

        else -> {
            Box(
                modifier = modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .height(100.dp)
                    .fillMaxWidth()
                    .clickable {
                        openPosHandler()
                    }, contentAlignment = Alignment.Center
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    text = stringResource(R.string.video_and_link_are_not_implemented_yet)
                )
            }
        }
    }
}
