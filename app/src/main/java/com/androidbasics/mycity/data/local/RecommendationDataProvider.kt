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
            description = R.string.coffee_recommendation_description,
            recommendations = CoffeeShopDataProvider.coffees
        ),
        Recommendation(
            name = R.string.restaurants,
            image = R.drawable.restaurant,
            screen = Screens.RESTAURANTS,
            description = R.string.restaurant_recommendation_description,
            recommendations = RestaurantDataProvider.restaurants
        ),
        Recommendation(
            name = R.string.kid_friendly_places,
            image = R.drawable.kid_friendly_place,
            screen = Screens.KID_FRIENDLY_PLACES,
            description = R.string.kid_friendly_place_recommendation_description,
            recommendations = KidFriendlyPlaceDataProvider.kidFriendlyPlaces
        ),
        Recommendation(
            name = R.string.parks,
            image = R.drawable.park,
            screen = Screens.PARKS,
            description = R.string.park_recommendation_description,
            recommendations = ParkDataProvider.parks
        ),
        Recommendation(
            name = R.string.shopping_center,
            image = R.drawable.shopping_center,
            screen = Screens.SHOPPING_CENTERS,
            description = R.string.shopping_center_recommendation_description,
            recommendations = ShoppingCenterDataProvider.shoppingCenters
        )
    )

    val defaultRecommendation = recommendations[0]
}