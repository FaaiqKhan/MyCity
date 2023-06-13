package com.androidbasics.mycity.data

import com.androidbasics.mycity.data.interfaces.Place

data class CoffeeShop(
    override val name: Int,
    override val image: Int,
    override val description: Int,
    val availableCoffeeType: List<CoffeeType>,
    val availableCoffeeSize: List<CoffeeSize>,
) : Place
