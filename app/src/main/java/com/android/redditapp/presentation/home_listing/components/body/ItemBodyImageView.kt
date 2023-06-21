package com.android.redditapp.presentation.home_listing.components.body

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ItemBodyImageView(
    title: String,
    image: String?,
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
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (image != null) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp),
                contentScale = ContentScale.Crop,
                model = image,
                contentDescription = null
            )
        }
    }
}
