package com.androidbasics.mycity.utils

import com.androidbasics.mycity.data.*

fun Any.getType(): Int {
    return when(this) {
        is CoffeeShop -> 0
        is Restaurant -> 1
        is KidFriendlyPlace -> 2
        is Park -> 3
        is ShoppingCenter -> 4
        else -> 0
    }
}

fun Any.copyAsCoffeeShop(): CoffeeShop {
    return this as CoffeeShop
}

fun Any.copyAsRestaurant(): Restaurant {
    return this as Restaurant
}