package com.android.redditapp.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.redditapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String, backgroundColor: Color
) {
    Box(
        modifier = Modifier.border(
            width = 0.5.dp,
            color = backgroundColor,
            shape = RoundedCornerShape(bottomStart = 7.dp, bottomEnd = 7.dp),
        )
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                backgroundColor, shape = RoundedCornerShape(5.dp)
                            )
                            .padding(5.dp)
                    ) {
                        Text(
                            text = title
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = stringResource(R.string.dropdown)
                        )
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