package com.androidbasics.mycity.data

import com.androidbasics.mycity.data.interfaces.Place

data class Recommendation(
    override val name: Int,
    override val image: Int,
    override val description: Int,
    val recommendations: List<Any>,
    val screen: Screens
) : Place
