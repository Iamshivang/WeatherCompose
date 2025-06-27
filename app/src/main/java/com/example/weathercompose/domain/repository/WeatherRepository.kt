package com.example.weathercompose.domain.repository

import com.example.weathercompose.data.remote.dto.ForecastResponse
import com.example.weathercompose.data.remote.dto.WeatherResponse
import com.example.weathercompose.domain.model.forecast.Item
import com.example.weathercompose.utils.Resource
import kotlinx.coroutines.flow.Flow

/*
 * Author: Shivang Yadav
 * Created: 6/26/25
 * Description: [Add description here]
 */


interface WeatherRepository {

    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double
    ): Flow<Resource<WeatherResponse>>

    suspend fun getFiveDaysForecast(
        lat: Double,
        lon: Double
    ): Flow<Resource<List<Item>>>

}