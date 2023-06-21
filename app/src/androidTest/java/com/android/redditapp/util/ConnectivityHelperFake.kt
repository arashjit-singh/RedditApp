package com.android.redditapp.util

import javax.inject.Inject

class ConnectivityHelperFake @Inject constructor() : ConnectivityHelper {
    override fun isNetworkAvailable(): Boolean {
        return true
    }
}