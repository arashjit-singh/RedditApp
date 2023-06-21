package com.android.redditapp.presentation.home_listing.components.footer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.redditapp.R

@Composable
fun RedditFooter(
    likeCount: String,
    commentCount: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .clickable {},
                painter = painterResource(id = R.drawable.icon_upvote),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                contentDescription = stringResource(R.string.upvote_icon)
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = likeCount,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .clickable {},
                painter = painterResource(id = R.drawable.icon_downvote),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                contentDescription = stringResource(R.string.downvote_icon)
            )
        }
        Row() {
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .clickable {},
                painter = painterResource(id = R.drawable.icon_comment),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                contentDescription = stringResource(R.string.comment_icon)
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = commentCount,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Row(modifier = Modifier.clickable {}) {
            Image(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.icon_share),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant),
                contentDescription = stringResource(R.string.share_icon)
            )
            Text(
                text = "Share",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}


@Composable
@Preview
fun PreviewRedditFooter() {
    RedditFooter("12", "23")
}