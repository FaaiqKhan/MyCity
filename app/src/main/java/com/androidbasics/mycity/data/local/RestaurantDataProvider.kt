package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.*

object RestaurantDataProvider {

    val restaurants = listOf(
        Restaurant(
            name = R.string.agra,
            availableFoodType = listOf(FoodType.DESSERT, FoodType.FULL_MEAL),
            availableOrderWeight = listOf(FoodWeight.ONE_KG, FoodWeight.THREE_KG),
            description = R.string.agra_description
        ),
        Restaurant(
            name = R.string.om,
            availableFoodType = listOf(FoodType.DESSERT),
            availableOrderWeight = listOf(FoodWeight.ONE_KG, FoodWeight.TWO_KG),
            description = R.string.om_description
        ),
        Restaurant(
            name = R.string.pizza_palast,
            availableFoodType = listOf(FoodType.DESSERT, FoodType.FULL_MEAL),
            availableOrderWeight = listOf(
                FoodWeight.ONE_KG,
                FoodWeight.TWO_KG,
                FoodWeight.THREE_KG
            ),
            description = R.string.pizza_palast_description
        ),
        Restaurant(
            name = R.string.der_everest_restaurant,
            availableFoodType = listOf(FoodType.FULL_MEAL),
            availableOrderWeight = listOf(FoodWeight.TWO_KG, FoodWeight.THREE_KG),
            description = R.string.der_everest_restaurant_description
        )
    )
    val defaultRestaurant = restaurants[0]
}