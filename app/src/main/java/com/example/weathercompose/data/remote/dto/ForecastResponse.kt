package com.example.weathercompose.data.remote.dto

import com.example.weathercompose.domain.model.forecast.City
import com.example.weathercompose.domain.model.forecast.Item

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Item>,
    val message: Int
)