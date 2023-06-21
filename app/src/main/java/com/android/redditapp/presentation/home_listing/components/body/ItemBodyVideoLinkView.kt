package com.android.redditapp.presentation.home_listing.components.body

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android.redditapp.R
import com.android.redditapp.domain.RedditModel

@Composable
fun ItemBodyVideoLinkView(
    post: RedditModel, onPostClickCallback: () -> Unit, modifier: Modifier = Modifier
) {

    Column(modifier = modifier.clickable {
        onPostClickCallback()
    }) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            maxLines = 2,
            text = post.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(
            modifier = modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .height(40.dp)
                .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                text = stringResource(R.string.video_and_link_are_not_implemented_yet)
            )
        }
    }
}
