package com.example.weathercompose.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/*
 * Author: Shivang Yadav
 * Created: 6/10/25
 * Description: [Add description here]
 */
object TimeUtils {

    fun convertUnixToTime(timestamp: Long): String {
        val date = Date(timestamp * 1000) // Convert seconds to milliseconds
        val formatter = SimpleDateFormat("hh:mm a", Locale.getDefault())
        formatter.timeZone = TimeZone.getDefault() // Use device's local time
        return formatter.format(date)
    }

    fun getFormattedCurrentDate(): String {
        val date = Date()
        val formatter = SimpleDateFormat("EEEE, dd MMM", Locale.getDefault())
        return formatter.format(date)
    }

    // Returns date in "13 Feb" format
    fun getDateFromTimestamp(timestamp: Long): String {
        val date = Date(timestamp * 1000) // Convert seconds to milliseconds
        val formatter = SimpleDateFormat("dd MMM", Locale.getDefault())
        return formatter.format(date)
    }

    // Returns day name in "Mon" format
    fun getDayNameFromTimestamp(timestamp: Long): String {
        val date = Date(timestamp * 1000)
        val formatter = SimpleDateFormat("EEE", Locale.getDefault()) // EEE = Mon
        return formatter.format(date)
    }

    fun isToday(timestamp: Long): Boolean{
        val date = Date(timestamp * 1000)
        val currentDate = Date()
        return SimpleDateFormat("dd", Locale.getDefault()).format(date) == SimpleDateFormat("dd", Locale.getDefault()).format(currentDate)
    }
}