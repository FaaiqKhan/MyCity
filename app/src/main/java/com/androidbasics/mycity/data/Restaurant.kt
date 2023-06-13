package com.androidbasics.mycity.data

import com.androidbasics.mycity.data.interfaces.Place

data class Restaurant(
    override val name: Int,
    override val image: Int,
    override val description: Int,
    val availableFoodType: List<FoodType>,
    val availableOrderWeight: List<FoodWeight>,
) : Place
