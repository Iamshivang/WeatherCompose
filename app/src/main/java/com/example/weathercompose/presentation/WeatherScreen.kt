package com.example.weathercompose.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weathercompose.presentation.components.ActionBar
import com.example.weathercompose.presentation.components.WeatherDetails
import com.example.weathercompose.presentation.components.DailyForecast
import com.example.weathercompose.presentation.components.LoadingState
import com.example.weathercompose.presentation.components.SunRiseSet
import com.example.weathercompose.presentation.components.Temperature
import com.example.weathercompose.presentation.components.WeaklyForecast
import com.example.weathercompose.presentation.theme.ColorBackground
import com.example.weathercompose.utils.Contstants.getAdditionalItemsList
import com.example.weathercompose.utils.Resource
import com.example.weathercompose.utils.ShimmerUtils.ShimmerEffect

/*
 * Author: Shivang Yadav
 * Created: 6/20/25
 * Description: [Add description here]
 */

@Composable
@Preview(showBackground = true)
fun WeatherScreen(
    viewModel: WeatherScreenViewModel = hiltViewModel(),
    lat: Double,
    lon: Double,
    onRefresh: ()-> Unit
){

    Log.d("WeatherScreen", "WeatherScreen: $lat, $lon")
    val city = remember { mutableStateOf("------") }

    LaunchedEffect(Unit) {
        viewModel.getCurrentWeather(
            lat = lat,
            lon= lon
        )

        viewModel.getFiveDaysForecast(
            lat = lat,
            lon= lon
        )
    }

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

            ActionBar(
                Modifier,
                onClick = {
                    onRefresh()
                    viewModel.getCurrentWeather(
                        lat = lat,
                        lon= lon
                    )

                    viewModel.getFiveDaysForecast(
                        lat = lat,
                        lon= lon
                    )
                },
                cityName = city.value
            )

            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )

            when(currentWeatherState) {
                is Resource.Error -> {}
                is Resource.Loading -> {

                    LoadingState()
                }
                is Resource.Success ->{

                    val response = currentWeatherState.data

                    city.value = response?.name!!

                    DailyForecast(
                        imageId = response.weather[0].icon,
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
                is Resource.Loading -> {

                    ShimmerEffect(Modifier
                        .fillMaxSize()
                        .height(160.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(12.dp)))
                }
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