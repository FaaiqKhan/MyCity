package com.androidbasics.mycity.data

import com.androidbasics.mycity.data.interfaces.Place
import com.androidbasics.mycity.data.local.RecommendationDataProvider

data class PlaceUiState(
    val place: Place = RecommendationDataProvider.defaultRecommendation,
    val currentNavigationItem: NavigationItemType = NavigationItemType.HOME,
)