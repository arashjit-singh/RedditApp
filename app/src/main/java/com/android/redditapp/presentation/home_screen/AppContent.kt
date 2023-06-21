package com.android.redditapp.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.android.redditapp.R
import com.android.redditapp.presentation.home_listing.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        TopBar(stringResource(R.string.label_home), Color(0XFFE9EBED))
    }) { innerPadding ->
        Box(modifier = modifier.padding(innerPadding)) {
            HomeScreen()
        }
    }
}
