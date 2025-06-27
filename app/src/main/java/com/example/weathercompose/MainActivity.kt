package com.example.weathercompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.example.weathercompose.data.remote.WeatherApi
import com.example.weathercompose.presentation.WeatherScreen
import com.example.weathercompose.presentation.theme.WeatherComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var api: WeatherApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            Log.d(TAG,api.getFiveDaysForecast(lat = 27.558750, lon = 78.662567).body().toString())
        }

        setContent {
            WeatherComposeTheme {
                WeatherScreen()
            }
        }
    }
}