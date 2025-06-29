package com.example.weathercompose.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weathercompose.utils.ShimmerUtils.ShimmerEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
 * Author: Shivang Yadav
 * Created: 6/28/25
 * Description: [Add description here]
 */

@Composable
fun LoadingState(
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        ShimmerEffect(
            Modifier
            .fillMaxSize()
            .height(160.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(32.dp)))

        ShimmerEffect(
            Modifier
                .fillMaxSize()
                .height(60.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(32.dp)))

        ShimmerEffect(
            Modifier
                .fillMaxSize()
                .height(60.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(32.dp)))

        ShimmerEffect(
            Modifier
                .fillMaxSize()
                .height(200.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(32.dp)))
    }
}