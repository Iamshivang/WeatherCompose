package com.example.weathercompose.domain.model.forecast

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)