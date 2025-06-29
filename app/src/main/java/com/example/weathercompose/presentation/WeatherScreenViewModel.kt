package com.example.weathercompose.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathercompose.data.remote.dto.WeatherResponse
import com.example.weathercompose.domain.model.forecast.Item
import com.example.weathercompose.domain.usecases.GetCurrentWeatherUseCase
import com.example.weathercompose.domain.usecases.GetForecastUseCase
import com.example.weathercompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
 * Author: Shivang Yadav
 * Created: 6/26/25
 * Description: [Add description here]
 */


@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val getForecastUseCase: GetForecastUseCase
): ViewModel(){

    var currentWeather by mutableStateOf<Resource<WeatherResponse>>(Resource.Loading())
            private set

    var fiveDaysForecast by mutableStateOf<Resource<List<Item>>>(Resource.Loading())
            private set

    fun getCurrentWeather(
        lat: Double = 27.558750,
        lon: Double = 78.662567
    )= viewModelScope.launch{
        getCurrentWeatherUseCase.invoke(
            lat = lat,
            lon = lon
        ).collect { result ->
            currentWeather = result
        }
    }

    fun getFiveDaysForecast(
        lat: Double = 27.558750,
        lon: Double = 78.662567
    ) = viewModelScope.launch {
        getForecastUseCase.invoke(
            lat = lat,
            lon = lon
        ).collect { result ->
            fiveDaysForecast = result
        }
    }
}