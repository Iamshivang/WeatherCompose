package com.example.weathercompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercompose.domain.model.AdditionalItem
import com.example.weathercompose.presentation.theme.ColorSurface
import com.example.weathercompose.R
import com.example.weathercompose.presentation.theme.ColorAirQualityIconTitle
import com.example.weathercompose.presentation.theme.ColorTextPrimary
import com.example.weathercompose.presentation.theme.ColorTextPrimaryVariant

/*
 * Author: Shivang Yadav
 * Created: 6/24/25
 * Description: [Add description here]
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WeatherDetails(
    modifier: Modifier = Modifier,
    data: List<AdditionalItem>
){
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        color = ColorSurface
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = 18.dp,
                horizontal = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Header()

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth(),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                data.onEach { item ->
                    WeatherItems(
                        data = item,
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            painter = painterResource(R.drawable.ic_info),
            contentDescription = null,
            tint = ColorAirQualityIconTitle,
            modifier = Modifier
                .size(28.dp)
        )

        Text(
            text = "Weather Details",
            style = MaterialTheme
                .typography
                .titleMedium
                .copy(
                    fontSize = 18.sp
                )
        )
    }
}

@Composable
private fun WeatherItems(
    modifier: Modifier = Modifier,
    data: AdditionalItem
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            painter = painterResource(data.icon),
            contentDescription = null,
            tint = ColorAirQualityIconTitle,
            modifier = Modifier
                .size(24.dp)
        )

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.labelSmall,
                color = ColorTextPrimaryVariant
            )
            Text(
                text = data.value,
                style = MaterialTheme.typography.labelSmall,
                color = ColorTextPrimary
            )
        }
    }
}