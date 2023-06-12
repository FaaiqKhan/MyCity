package com.androidbasics.mycity.data.local

import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.Recommendation

object RecommendationDataProvider {

    val recommendations = listOf(
        Recommendation(
            name = R.string.coffee_shop,
            image = R.drawable.coffee_shop,
            recommendations = CoffeeShopDataProvider.coffees
        ),
        Recommendation(
            name = R.string.restaurants,
            image = R.drawable.restaurant,
            recommendations = RestaurantDataProvider.restaurants
        ),
        Recommendation(
            name = R.string.kid_friendly_places,
            image = R.drawable.kid_friendly_place,
            recommendations = KidFriendlyPlaceDataProvider.kidFriendlyPlaces
        ),
        Recommendation(
            name = R.string.parks,
            image = R.drawable.park,
            recommendations = ParkDataProvider.parks
        ),
        Recommendation(
            name = R.string.shopping_center,
            image = R.drawable.shopping_center,
            recommendations = ShoppingCenterDataProvider.shoppingCenters
        )
    )

    val defaultRecommendation = recommendations[0]
}