package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.ShoppingCenter

object ShoppingCenterDataProvider {

    val shoppingCenters = listOf(
        ShoppingCenter(
            name = R.string.the_playce,
            hasFoodCort = true,
            hasJewelryShops = false,
            description = R.string.the_playce_description
        ),
        ShoppingCenter(
            name = R.string.mall_of_berlin,
            hasFoodCort = true,
            hasJewelryShops = true,
            description = R.string.mall_of_berlin_description
        ),
        ShoppingCenter(
            name = R.string.einkaufsbahnof_berlin_hbf,
            hasFoodCort = false,
            hasJewelryShops = true,
            description = R.string.einkaufsbahnof_berlin_hbf_description
        ),
        ShoppingCenter(
            name = R.string.alexa_berlin,
            hasFoodCort = true,
            hasJewelryShops = true,
            description = R.string.alexa_berlin_description
        )
    )

    val defaultShoppingCenter = shoppingCenters[0]
}