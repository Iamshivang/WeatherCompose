package com.example.weathercompose.domain.usecases

import com.example.weathercompose.domain.repository.WeatherRepository
import javax.inject.Inject

/*
 * Author: Shivang Yadav
 * Created: 6/26/25
 * Description: [Add description here]
 */

class GetForecastUseCase @Inject constructor(
    private val repo: WeatherRepository
){
    suspend operator fun invoke(
        lat: Double,
        lon: Double
    )= repo.getFiveDaysForecast(
        lat= lat,
        lon = lon
    )
}