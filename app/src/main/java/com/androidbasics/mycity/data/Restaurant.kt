package com.androidbasics.mycity.data

import androidx.annotation.StringRes

data class Restaurant(
    @StringRes val name: Int,
    val availableFoodType: List<FoodType>,
    val availableOrderWeight: List<FoodWeight>,
    @StringRes val description: Int,
)
