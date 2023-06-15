package com.androidbasics.mycity.data

import androidx.annotation.StringRes
import com.androidbasics.mycity.R

enum class FoodType {
    DESSERT, FULL_MEAL
}

enum class FoodWeight {
    ONE_KG, TWO_KG, THREE_KG
}

enum class CoffeeType {
    HOT, COLD
}

enum class CoffeeSize {
    SMALL, MEDIUM, LARGE
}

enum class Screens(@StringRes val title: Int) {
    RECOMMENDATIONS(title = R.string.recommendation),
    COFFEE_SHOPS(title = R.string.coffee_shop),
    RESTAURANTS(title = R.string.restaurants),
    KID_FRIENDLY_PLACES(title = R.string.kid_friendly_places),
    PARKS(title = R.string.parks),
    SHOPPING_CENTERS(title = R.string.shopping_center),
    COFFEE_SHOP_DETAILS(title = R.string.coffee_shop_details),
    RESTAURANT_DETAILS(title = R.string.restaurant_details),
    KID_FRIENDLY_PLACE_DETAILS(title = R.string.kid_friendly_place_details),
    PARK_DETAILS(title = R.string.park_details),
    SHOPPING_CENTER_DETAILS(title = R.string.shopping_center_details),
}

enum class NavigationItemType() {
    HOME,
    PROFILE,
    INFO
}