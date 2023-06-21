package com.android.redditapp.presentation.home_listing.components.body

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            ItemBodyVideoLinkView(post, onPostClickCallback = {
                openPosHandler()
            })
        }
    }
}
