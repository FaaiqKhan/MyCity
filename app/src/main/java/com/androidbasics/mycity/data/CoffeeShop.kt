package com.androidbasics.mycity.data

import androidx.annotation.StringRes

data class CoffeeShop(
    @StringRes val name: Int,
    val availableCoffeeType: List<CoffeeType>,
    val availableCoffeeSize: List<CoffeeSize>,
    @StringRes val description: Int,
)
