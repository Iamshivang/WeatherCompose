package com.example.weathercompose.ui.screen.utils

import androidx.annotation.DrawableRes
import com.example.weathercompose.R

/*
 * Author: Shivang Yadav
 * Created: 6/24/25
 * Description: [Add description here]
 */
data class AirQualityItem(
    @DrawableRes val icon: Int,
    val title: String,
    val value: String
)

val AirQualityData = listOf(

    AirQualityItem(
        title = "Real Feel",
        value = "23.8",
        icon = R.drawable.ic_clear_sky
    ),

    AirQualityItem(
        title = "Wind",
        value = "9km/h",
        icon = R.drawable.ic_wind
    ),

    AirQualityItem(
        title = "SO2",
        value = "0.09",
        icon = R.drawable.ic_so2
    ),

    AirQualityItem(
        title = "Rain",
        value = "68%",
        icon = R.drawable.ic_rainy
    ),

    AirQualityItem(
        title = "UV Index",
        value = "3",
        icon = R.drawable.ic_uv
    ),

    AirQualityItem(
        title = "O3",
        value = "50",
        icon =R.drawable.ic_o3
    ),
)
