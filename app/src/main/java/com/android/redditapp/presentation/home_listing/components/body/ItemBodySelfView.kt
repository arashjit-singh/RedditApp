package com.android.redditapp.presentation.home_listing.components.body

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ItemBodySelfView(
    title: String, content: String?,
    onPostClickCallback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.clickable {
        onPostClickCallback()
    }) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            text = title,
            maxLines = 2,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (!content.isNullOrEmpty()) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                text = content,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
