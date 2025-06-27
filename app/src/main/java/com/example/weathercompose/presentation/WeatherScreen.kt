package com.example.weathercompose.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weathercompose.presentation.components.ActionBar
import com.example.weathercompose.presentation.components.WeatherDetails
import com.example.weathercompose.presentation.components.DailyForecast
import com.example.weathercompose.presentation.components.SunRiseSet
import com.example.weathercompose.presentation.components.Temperature
import com.example.weathercompose.presentation.components.WeaklyForecast
import com.example.weathercompose.presentation.theme.ColorBackground
import com.example.weathercompose.utils.Contstants.getAdditionalItemsList
import com.example.weathercompose.utils.Resource

/*
 * Author: Shivang Yadav
 * Created: 6/20/25
 * Description: [Add description here]
 */

@Composable
@Preview(showBackground = true)
fun WeatherScreen(
    viewModel: WeatherScreenViewModel = hiltViewModel()
){
    val currentWeatherState = viewModel.currentWeather
    val forecastState = viewModel.fiveDaysForecast

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = ColorBackground
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(horizontal = 12.dp,
                    vertical = 10.dp)
        ) {

            when(currentWeatherState) {
                is Resource.Error -> {}
                is Resource.Idle -> {}
                is Resource.Loading -> {}
                is Resource.Success ->{

                    val response = currentWeatherState.data

                    ActionBar(Modifier,
                        cityName = response?.name.toString(),
                        onClick = {
                            viewModel.getCurrentWeather()
                        }
                    )

                    Spacer(
                        modifier = Modifier
                            .height(12.dp)
                    )


                    DailyForecast(
                        imageId =response?.weather[0]!!.icon,
                        forecast = response.weather[0].description,
                        temp = response.main.temp.toInt().toString(),
                        feelsLike = response.main.feels_like.toString()
                    )

                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                    )

                    SunRiseSet(
                        sunRise = response.sys.sunrise,
                        sunSet = response.sys.sunset
                    )

                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                    )

                    Temperature(
                        minTemp = response.main.temp_min.toInt(),
                        maxTemp = response.main.temp_max.toInt()
                    )

                    Spacer(
                        modifier = Modifier
                            .height(24.dp)
                    )

                    WeatherDetails(
                        data = getAdditionalItemsList(
                            direction = response.wind.deg,
                            speed = response.wind.speed,
                            gust = response.wind.gust,
                            cloudiness = response.clouds.all,
                            pressure = response.main.pressure,
                            humidity = response.main.humidity,
                            visibility = response.visibility,
                        )
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            when(forecastState) {
                is Resource.Error -> {}
                is Resource.Idle -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {

                    val dailyForecast = forecastState.data?.filter {
                        it.dt_txt.contains("12:00:00")
                    }

                    WeaklyForecast(
                        items = dailyForecast!!
                    )
                }
            }
        }
    }
}