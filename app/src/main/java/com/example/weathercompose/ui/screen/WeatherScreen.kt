package com.example.weathercompose.ui.screen

import androidx.compose.foundation.gestures.scrollable
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
import com.example.weathercompose.ui.screen.components.ActionBar
import com.example.weathercompose.ui.screen.components.AirQuality
import com.example.weathercompose.ui.screen.components.DailyForecast
import com.example.weathercompose.ui.screen.components.WeaklyForecast
import com.example.weathercompose.ui.theme.ColorBackground

/*
 * Author: Shivang Yadav
 * Created: 6/20/25
 * Description: [Add description here]
 */

@Composable
@Preview(showBackground = true)
fun WeatherScreen(){

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
            ActionBar(Modifier)

            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )

            DailyForecast()

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            AirQuality()

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            WeaklyForecast()
        }
    }
}