package com.androidbasics.mycity.data

import com.androidbasics.mycity.data.interfaces.Place

data class ShoppingCenter(
    override val name: Int,
    override val image: Int,
    override val description: Int,
    val hasFoodCort: Boolean,
    val hasJewelryShops: Boolean,
) : Place
