package com.android.redditapp.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ConnectivityHelperImpl @Inject constructor(@ApplicationContext private val context: Context) :
    ConnectivityHelper {
    override fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            ContextCompat.getSystemService(context, ConnectivityManager::class.java)
        val networkCapabilities = connectivityManager?.activeNetwork ?: return false
        val capabilities =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}