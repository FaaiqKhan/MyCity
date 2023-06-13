package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.*

object CoffeeShopDataProvider {

    val coffees = listOf(
        CoffeeShop(
            name = R.string.kara_mel,
            availableCoffeeType = listOf(CoffeeType.HOT, CoffeeType.COLD),
            availableCoffeeSize = listOf(CoffeeSize.SMALL, CoffeeSize.MEDIUM),
            image = R.drawable.kara_mell_coffee_shop,
            description = R.string.kara_mel_description,
        ),
        CoffeeShop(
            name = R.string.california_coffee_shop,
            availableCoffeeType = listOf(CoffeeType.HOT, CoffeeType.COLD),
            availableCoffeeSize = listOf(CoffeeSize.SMALL, CoffeeSize.MEDIUM, CoffeeSize.LARGE),
            image = R.drawable.california_coffee_company,
            description = R.string.california_coffee_shop_description
        ),
        CoffeeShop(
            name = R.string.exclusive_shop,
            availableCoffeeType = listOf(CoffeeType.COLD),
            availableCoffeeSize = listOf(CoffeeSize.MEDIUM, CoffeeSize.LARGE),
            image = R.drawable.exclusive_coffee,
            description = R.string.exclusive_shop_description
        ),
        CoffeeShop(
            name = R.string.coffee_mamas_shop,
            availableCoffeeType = listOf(CoffeeType.HOT),
            availableCoffeeSize = listOf(CoffeeSize.SMALL, CoffeeSize.LARGE),
            image = R.drawable.coffeemamas_shop,
            description = R.string.coffee_mamas_shop_description
        )
    )
    val defaultCoffee = coffees[0]
}