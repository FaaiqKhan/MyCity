package com.androidbasics.mycity.data

import androidx.annotation.StringRes

data class KidFriendlyPlace(
    @StringRes val name: Int,
    val hasTicket: Boolean,
    val ticketPrice: Double,
    val hasAnimals: Boolean,
    @StringRes val description: Int,
)
