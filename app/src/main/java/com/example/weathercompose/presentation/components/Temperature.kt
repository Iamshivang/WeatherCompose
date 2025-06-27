package com.example.weathercompose.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercompose.presentation.theme.ColorSurface
import com.example.weathercompose.R
import com.example.weathercompose.presentation.theme.ColorTextPrimary
import com.example.weathercompose.presentation.theme.ColorTextPrimaryVariant

/*
 * Author: Shivang Yadav
 * Created: 6/24/25
 * Description: [Add description here]
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Temperature(
    modifier: Modifier = Modifier,
    minTemp: Int = 23,
    maxTemp: Int = 40
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
            TemperatureHeader()

            Content(
                minTemp = minTemp,
                maxTemp = maxTemp
            )
        }
    }
}

@Composable
private fun TemperatureHeader(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){

        Image(
            painter = painterResource(R.drawable.ic_temperature),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
        )

        Text(
            text = "Temperature",
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
private fun Content(
    modifier: Modifier = Modifier,
    minTemp: Int,
    maxTemp: Int
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            style = MaterialTheme.typography.bodyLarge,
            color = ColorTextPrimaryVariant,
            text = buildAnnotatedString {
                append("Minimum: ")
                withStyle(
                    style = SpanStyle(
                        color = ColorTextPrimary,
                    )
                ) {
                    append("$minTemp°C")
                }
            }
        )

        Text(
            style = MaterialTheme.typography.bodyLarge,
            color = ColorTextPrimaryVariant,
            text = buildAnnotatedString {
                append("Maximum: ")
                withStyle(
                    style = SpanStyle(
                        color = ColorTextPrimary,
                    )
                ) {
                    append("$maxTemp°C")
                }
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewTemperature(){
    Temperature()
}