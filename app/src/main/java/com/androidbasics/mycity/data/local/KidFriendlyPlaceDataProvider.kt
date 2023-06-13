package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.KidFriendlyPlace

object KidFriendlyPlaceDataProvider {

    val kidFriendlyPlaces = listOf(
        KidFriendlyPlace(
            name = R.string.elefantentor,
            hasTicket = true,
            ticketPrice = 3.0,
            hasAnimals = true,
            image = R.drawable.elefantentor_kid_friendly,
            description = R.string.elefantentor_description
        ),
        KidFriendlyPlace(
            name = R.string.tiergarten,
            hasTicket = false,
            ticketPrice = 0.0,
            hasAnimals = true,
            image = R.drawable.tiergarten_kid_friendly,
            description = R.string.tiergarten_description
        ),
        KidFriendlyPlace(
            name = R.string.bunte_treppe,
            hasTicket = true,
            ticketPrice = 5.60,
            hasAnimals = true,
            image = R.drawable.bunte_treppe_kid_friendly,
            description = R.string.bunte_treppe_description
        ),
        KidFriendlyPlace(
            name = R.string.spreebogen_park,
            hasTicket = false,
            ticketPrice = 0.0,
            hasAnimals = true,
            image = R.drawable.spreeebogan_park_kid_firendly,
            description = R.string.spreebogen_park_description
        )
    )

    val defaultKidFriendlyPlace = kidFriendlyPlaces[0]
}