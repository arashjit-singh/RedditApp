package com.android.redditapp.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.redditapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String, backgroundColor: Color
) {
    Box(
        modifier = Modifier.border(
            width = 0.5.dp,
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = RoundedCornerShape(bottomStart = 7.dp, bottomEnd = 7.dp),
        )
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ) {

                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                    ) {

                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = stringResource(R.string.dropdown),
                            modifier = Modifier.align(CenterVertically)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Row(
                            modifier = Modifier
                                .background(
                                    MaterialTheme.colorScheme.surfaceVariant,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(start = 7.dp, end = 5.dp, top = 3.dp, bottom = 3.dp),
                            verticalAlignment = CenterVertically
                        ) {

                            Text(
                                text = title,
                                fontSize = 20.sp
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = stringResource(R.string.dropdown)
                            )
                        }
                    }

                    Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.search_icon),
                            modifier = Modifier.padding(10.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = stringResource(R.string.home_icon),
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            },
        )
    }

}

@Composable
@Preview
fun PreviewTopBar() {
    TopBar(title = "Home", backgroundColor = Color.LightGray)
}