package com.android.redditapp.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.android.redditapp.R

class AppHelper(val context: Context) {
    fun openPostOnSubreddit(subredditName: String, postId: String) {
        try {
            val redditPostUrl =
                context.getString(R.string.reddit_redirect_url).format(subredditName, postId)
            val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse(redditPostUrl)
            )
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(
                context,
                context.getString(R.string.no_app_available_to_open_the_post), Toast.LENGTH_SHORT
            ).show()
        }
    }
}