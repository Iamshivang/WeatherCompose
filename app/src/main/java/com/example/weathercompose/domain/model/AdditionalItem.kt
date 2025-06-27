package com.example.weathercompose.domain.model

import androidx.annotation.DrawableRes
import com.example.weathercompose.R

/*
 * Author: Shivang Yadav
 * Created: 6/24/25
 * Description: [Add description here]
 */
data class AdditionalItem(
    @DrawableRes val icon: Int,
    val title: String,
    val value: String
)