package com.androidbasics.mycity.data

import androidx.annotation.StringRes

data class ShoppingCenter(
    @StringRes val name: Int,
    val hasFoodCort: Boolean,
    val hasJewelryShops: Boolean,
    @StringRes val description: Int,
)
