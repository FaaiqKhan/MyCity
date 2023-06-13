package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.Park

object ParkDataProvider {

    val parks = listOf(
        Park(
            name = R.string.carl_von_ossietzky_park,
            hasTicket = false,
            ticketPrice = 0.0,
            hasLake = true,
            image = R.drawable.carl_won_ossietzky_park,
            description = R.string.carl_von_ossietzky_park_description
        ),
        Park(
            name = R.string.henriette_herz_park,
            hasTicket = true,
            ticketPrice = 2.50,
            hasLake = true,
            image = R.drawable.henriette_herz_park,
            description = R.string.henriette_herz_park_description
        ),
        Park(
            name = R.string.playground_tiergarten,
            hasTicket = false,
            ticketPrice = 0.0,
            hasLake = false,
            image = R.drawable.playground_tiergarten_park,
            description = R.string.playground_tiergarten_description
        ),
        Park(
            name = R.string.james_simon_park,
            hasTicket = true,
            ticketPrice = 4.70,
            hasLake = true,
            image = R.drawable.james_simon_park,
            description = R.string.james_simon_park_description
        )
    )

    val defaultPark = parks[0]
}