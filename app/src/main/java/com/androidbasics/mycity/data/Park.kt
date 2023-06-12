package com.androidbasics.mycity.data

import androidx.annotation.StringRes

data class Park(
    @StringRes val name: Int,
    val hasTicket: Boolean,
    val ticketPrice: Double,
    val hasLake: Boolean,
    @StringRes val description: Int,
)
