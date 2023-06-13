package com.androidbasics.mycity.data

import com.androidbasics.mycity.data.interfaces.Place

data class Park(
    override val name: Int,
    override val image: Int,
    override val description: Int,
    val hasTicket: Boolean,
    val ticketPrice: Double,
    val hasLake: Boolean,
) : Place
