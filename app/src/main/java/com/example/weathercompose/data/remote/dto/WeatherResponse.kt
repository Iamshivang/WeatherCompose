package com.example.weathercompose.data.remote.dto

import com.example.weathercompose.domain.model.weather.Clouds
import com.example.weathercompose.domain.model.weather.Coord
import com.example.weathercompose.domain.model.weather.Main
import com.example.weathercompose.domain.model.weather.Sys
import com.example.weathercompose.domain.model.weather.Weather
import com.example.weathercompose.domain.model.weather.Wind

data class WeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)