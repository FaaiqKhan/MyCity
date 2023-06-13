package com.androidbasics.mycity.data.interfaces

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface Place {

    @get:StringRes
    val name: Int

    @get:DrawableRes
    val image: Int

    @get:StringRes
    val description: Int
}