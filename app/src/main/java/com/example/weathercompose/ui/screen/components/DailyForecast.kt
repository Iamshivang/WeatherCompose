package com.example.weathercompose.ui.screen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.weathercompose.R
import com.example.weathercompose.ui.theme.ColorGradient1
import com.example.weathercompose.ui.theme.ColorGradient2
import com.example.weathercompose.ui.theme.ColorGradient3
import com.example.weathercompose.ui.theme.ColorTextPrimaryVariant
import com.example.weathercompose.ui.theme.ColorTextSecondary
import com.example.weathercompose.ui.theme.ColorTextSecondaryVariant
import com.example.weathercompose.ui.theme.ColorWindForecast
import java.nio.file.WatchEvent

/*
 * Author: Shivang Yadav
 * Created: 6/24/25
 * Description: [Add description here]
 */


@Composable
@Preview(showBackground = true)
fun DailyForecast(
    modifier: Modifier = Modifier,
    forecast: String = "Rain showers",
    date: String = "Monday, 12 Feb"
){
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
    ){
        val (forecastImage, forecastValue, windImage, title, description, background) = createRefs()

        CardBackground(
            modifier = Modifier
                .constrainAs(background) {
                    linkTo(
                        start = parent.start,
                        top = parent.top,
                        end = parent.end,
                        bottom = description.bottom,
                        topMargin = 24.dp
                    )
                    height = Dimension.fillToConstraints
                }
        )

        Image(
            painter = painterResource(R.drawable.img_cloudy_rain),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(175.dp)
                .constrainAs(forecastImage) {
                    start.linkTo(anchor = parent.start, margin = 4.dp)
                    top.linkTo(anchor = parent.top)
                }
        )

        Text(
            text = forecast,
            style = MaterialTheme.typography.titleLarge,
            color = ColorTextSecondary,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(anchor = parent.start, margin = 24.dp)
                    top.linkTo(anchor = forecastImage.bottom)
                }
        )

        Text(
            text = date,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant,
            modifier = Modifier
                .constrainAs(description) {
                    start.linkTo(anchor = title.start)
                    top.linkTo(anchor = title.bottom)
                }
                .padding(bottom = 24.dp)
        )

        ForecastValue(
            modifier = Modifier
                .constrainAs(forecastValue) {
                    end.linkTo(anchor = parent.end, margin = 24.dp)
                    top.linkTo(anchor = forecastImage.top)
                    bottom.linkTo(anchor = forecastImage.bottom)
                }
        )

        WindForecastImage(
            modifier = Modifier
                .constrainAs(windImage) {
                    linkTo(
                        top = title.top,
                        bottom = title.bottom
                    )
                    end.linkTo(
                        anchor = parent.end,
                        margin = 24.dp
                    )
                }
        )
    }
}

@Composable
private fun CardBackground(
    modifier: Modifier= Modifier
){

    Box(
        modifier= modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.5f to ColorGradient2,
                    1f to ColorGradient3
                ),
                shape = RoundedCornerShape(32.dp)
            )
    )
}

@Composable
private fun ForecastValue(
    modifier: Modifier = Modifier,
    degree: String = "21",
    description: String = "Feels like 45"
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ){
            Text(
                text = degree,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Black
                )
            )

            Text(
                text = "°",
                style = TextStyle(
                    brush = Brush.linearGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Light
                )
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant
        )
    }
}

@Composable
private fun WindForecastImage(
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Icon(
            painter = painterResource(R.drawable.img_snowflake),
            contentDescription = null,
            tint = ColorWindForecast,
            modifier= Modifier
                .size(50.dp)
        )

        Icon(
            painter = painterResource(R.drawable.img_wind),
            contentDescription = null,
            tint = ColorWindForecast,
            modifier= Modifier
                .size(50.dp)
        )
    }
}