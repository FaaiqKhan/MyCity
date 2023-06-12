package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.*

object CoffeeShopDataProvider {

    val coffees = listOf(
        CoffeeShop(
            name = R.string.kara_mel,
            availableCoffeeType = listOf(CoffeeType.HOT, CoffeeType.COLD),
            availableCoffeeSize = listOf(CoffeeSize.SMALL, CoffeeSize.MEDIUM),
            description = R.string.kara_mel_description,
        ),
        CoffeeShop(
            name = R.string.california_coffee_shop,
            availableCoffeeType = listOf(CoffeeType.HOT, CoffeeType.COLD),
            availableCoffeeSize = listOf(CoffeeSize.SMALL, CoffeeSize.MEDIUM, CoffeeSize.LARGE),
            description = R.string.california_coffee_shop_description
        ),
        CoffeeShop(
            name = R.string.exclusive_shop,
            availableCoffeeType = listOf(CoffeeType.COLD),
            availableCoffeeSize = listOf(CoffeeSize.MEDIUM, CoffeeSize.LARGE),
            description = R.string.exclusive_shop_description
        ),
        CoffeeShop(
            name = R.string.california_coffee_shop,
            availableCoffeeType = listOf(CoffeeType.HOT),
            availableCoffeeSize = listOf(CoffeeSize.SMALL, CoffeeSize.LARGE),
            description = R.string.california_coffee_shop_description
        )
    )
    val defaultCoffee = coffees[0]
}