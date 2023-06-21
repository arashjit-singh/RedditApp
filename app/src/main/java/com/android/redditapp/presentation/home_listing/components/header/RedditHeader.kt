package com.android.redditapp.presentation.home_listing.components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.redditapp.R
import com.android.redditapp.util.DateHelper

@Composable
fun RedditHeader(
    userThumbNail: String?,
    subredditName: String,
    authorFullName: String,
    createdAt: Long,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(48.dp)
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = userThumbNail,
            contentDescription = stringResource(R.string.user_thumbnail_image),
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            alignment = Alignment.CenterEnd,
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1f)
        ) {
            Row() {
                Text(
                    text = subredditName,
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string.posted_by).format(authorFullName),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Text(
                text = DateHelper().getTimeAgo(time = createdAt),
                style = MaterialTheme.typography.labelMedium
            )
        }
        Image(
            imageVector = Icons.Default.MoreVert,
            contentDescription = stringResource(R.string.post_action_button),
            modifier = Modifier.size(24.dp),
            alignment = Alignment.CenterEnd,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSurfaceVariant)
        )
    }
}

@Preview
@Composable
fun PreviewHeaderView() {
    RedditHeader(
        userThumbNail = "https://b.thumbs.redditmedia.com/1DWqh0XjyFn4HhlWx1xq3_bARDa7V-_Vto3ep1wUqZc.jpg",
        subredditName = "technology",
        authorFullName = "t2_1z97uer",
        createdAt = 1687274811
    )
}