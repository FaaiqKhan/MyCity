package com.androidbasics.mycity.data

import androidx.annotation.*

data class Recommendation(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val recommendations: List<Any>
)
