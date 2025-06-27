package com.example.weathercompose.data.remote

import com.example.weathercompose.data.remote.dto.ForecastResponse
import com.example.weathercompose.data.remote.dto.WeatherResponse
import com.example.weathercompose.utils.Contstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Author: Shivang Yadav
 * Created: 6/26/25
 * Description: Contains API calls for Weather
 */


interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("appid")
        appid: String = Contstants.API_KEY,
        @Query("units")
        units: String = Contstants.UNIT
    ): Response<WeatherResponse>

    @GET("data/2.5/forecast")
    suspend fun getFiveDaysForecast(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("appid")
        appid: String = Contstants.API_KEY,
        @Query("units")
        units: String = Contstants.UNIT
    ): Response<ForecastResponse>
}