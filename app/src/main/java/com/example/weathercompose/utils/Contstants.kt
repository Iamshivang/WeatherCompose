package com.example.weathercompose.utils

import androidx.compose.ui.graphics.Color
import com.example.weathercompose.R
import com.example.weathercompose.domain.model.AdditionalItem

/*
 * Author: Shivang Yadav
 * Created: 6/26/25
 * Description: [Add description here]
 */
object Contstants {

    const val API_KEY = "aa0abba60e9d2943e55403d1eb4b9d7a"
    const val BASE_URL = "https://api.openweathermap.org/"
    const val UNIT = "metric"

    fun getImageUrl(imageId: String): String = "https://openweathermap.org/img/wn/$imageId@2x.png"

    fun getAdditionalItemsList(
        direction: Int,
        speed: Double,
        gust: Double,
        cloudiness: Int,
        pressure: Int,
        humidity: Int,
        visibility: Int
    ): List<AdditionalItem> {
        return listOf(
            AdditionalItem(
                title = "Wind Direction",
                value = "$direction°",
                icon = R.drawable.ic_direction
            ),
            AdditionalItem(
                title = "Wind Speed",
                value = "${speed}m/s",
                icon = R.drawable.ic_wind
            ),
            AdditionalItem(
                title = "Wind Gust",
                value = "${gust}m/s",
                icon = R.drawable.img_wind
            ),
            AdditionalItem(
                title = "Cloudiness",
                value = "${cloudiness}%",
                icon = R.drawable.ic_cloud
            ),
            AdditionalItem(
                title = "Pressure",
                value = "${pressure}hPa",
                icon = R.drawable.ic_atmos_pressure
            ),
            AdditionalItem(
                title = "Humidity",
                value = "${humidity}%",
                icon = R.drawable.ic_humidity
            ),
            AdditionalItem(
                title = "Visibility",
                value = "${visibility/1000}km",
                icon = R.drawable.ic_visibility
            ),
        )
    }

    fun getGustColor(gust: Double): String {
        return when {
            gust < 5.0 -> "#2dbe8d"
            gust < 10.0 -> "#f9cf5f"
            else -> "#ff7676"
        }
    }
}