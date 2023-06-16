package com.androidbasics.mycity

import com.androidbasics.mycity.data.local.CoffeeShopDataProvider
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MyCityAppUnitTest {

    @Test
    fun verify_twoObjects_comparison_give_true() {
        val coffeeShop = CoffeeShopDataProvider.defaultCoffee
        val coffeeShopClone = CoffeeShopDataProvider.defaultCoffee

        assertEquals(coffeeShop, coffeeShopClone)
    }
}