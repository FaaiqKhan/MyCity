package com.androidbasics.mycity.data

import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Coffee(
    val type: CoffeeType,
    val size: CoffeeSize,
    @IntegerRes val price: Int,
    @StringRes val description: Int,
)
