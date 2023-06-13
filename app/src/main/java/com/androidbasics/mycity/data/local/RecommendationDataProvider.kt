package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.Recommendation
import com.androidbasics.mycity.data.Screens

object RecommendationDataProvider {

    val recommendations = listOf(
        Recommendation(
            name = R.string.coffee_shop,
            image = R.drawable.coffee_shop,
            screen = Screens.COFFEE_SHOPS,
            recommendations = CoffeeShopDataProvider.coffees
        ),
        Recommendation(
            name = R.string.restaurants,
            image = R.drawable.restaurant,
            screen = Screens.RESTAURANTS,
            recommendations = RestaurantDataProvider.restaurants
        ),
        Recommendation(
            name = R.string.kid_friendly_places,
            image = R.drawable.kid_friendly_place,
            screen = Screens.KID_FRIENDLY_PLACES,
            recommendations = KidFriendlyPlaceDataProvider.kidFriendlyPlaces
        ),
        Recommendation(
            name = R.string.parks,
            image = R.drawable.park,
            screen = Screens.PARKS,
            recommendations = ParkDataProvider.parks
        ),
        Recommendation(
            name = R.string.shopping_center,
            image = R.drawable.shopping_center,
            screen = Screens.SHOPPING_CENTERS,
            recommendations = ShoppingCenterDataProvider.shoppingCenters
        )
    )

    val defaultRecommendation = recommendations[0]
}