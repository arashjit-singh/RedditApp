package com.android.redditapp.util

class DateHelper {

    fun getTimeAgo(time: Long): String {

        val SECOND_MILLIS = 1000;
        val MINUTE_MILLIS = 60 * SECOND_MILLIS;
        val HOUR_MILLIS = 60 * MINUTE_MILLIS;
        val DAY_MILLIS = 24 * HOUR_MILLIS;

        val diff = System.currentTimeMillis() - time * 1000;
        return if (diff < MINUTE_MILLIS) {
            "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            " ${diff / MINUTE_MILLIS} minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            "an hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            "${diff / HOUR_MILLIS} hours ago";
        } else if (diff < 48 * HOUR_MILLIS) {
            "yesterday";
        } else {
            "${diff / DAY_MILLIS} days ago";
        }
    }
}