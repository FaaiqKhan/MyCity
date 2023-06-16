package com.androidbasics.mycity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.*
import com.androidbasics.mycity.data.interfaces.Place
import com.androidbasics.mycity.data.local.RecommendationDataProvider
import com.androidbasics.mycity.ui.common.PlaceItem
import com.androidbasics.mycity.ui.common.RecommendationItem
import com.androidbasics.mycity.ui.theme.MyCityTheme
import com.androidbasics.mycity.utils.Utils.MyCityContentType

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RecommendationScreen(
    recommendations: List<Recommendation>,
    modifier: Modifier = Modifier,
    onClick: (selectedRecommendation: Recommendation) -> Unit,
    contentType: MyCityContentType,
    placeUiState: PlaceUiState
) {
    var selectedPlace by remember { mutableStateOf<Place?>(null) }
    var placeTitle by remember { mutableStateOf<Screens?>(null) }

    val visibleState = remember {
        MutableTransitionState(initialState = false).apply { targetState = true }
    }

    if (contentType == MyCityContentType.LIST_AND_DETAIL) {
        val places =
            RecommendationDataProvider.recommendations.find { it.name == placeUiState.place.name }
        Row(modifier = modifier) {
            AnimatedVisibility(
                visibleState = visibleState,
                enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)),
                exit = fadeOut(),
                modifier = modifier.weight(0.7f),
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
                ) {
                    for (i in recommendations.indices) {
                        RecommendationItem(
                            recommendation = recommendations[i],
                            onClick = { selectedRecommendation -> onClick(selectedRecommendation) },
                            modifier = Modifier.animateEnterExit(
                                enter = slideInVertically(
                                    animationSpec = spring(
                                        stiffness = Spring.StiffnessVeryLow,
                                        dampingRatio = Spring.DampingRatioLowBouncy
                                    ),
                                    initialOffsetY = { it * (i + 1) } // staggered entrance
                                )
                            )
                        )
                    }
                }
            }
            if (selectedPlace == null && places != null) {
                AnimatedVisibility(
                    visibleState = visibleState,
                    modifier = modifier.weight(1f),
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)),
                    exit = fadeOut(),
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(
                            space = dimensionResource(id = R.dimen.padding_medium)
                        )
                    ) {
                        for (i in places.recommendations.indices) {
                            PlaceItem(
                                suggestedPlace = places.recommendations[i] as Place,
                                onClick = { place -> selectedPlace = place },
                                modifier = Modifier.animateEnterExit(
                                    enter = slideInHorizontally (
                                        animationSpec = spring(
                                            stiffness = Spring.StiffnessVeryLow,
                                            dampingRatio = Spring.DampingRatioLowBouncy
                                        ),
                                        initialOffsetX = { it * (i + 1) } // staggered entrance
                                    )
                                )
                            )
                        }
                    }
                }

            } else if (selectedPlace != null) {
                Column(modifier = modifier.weight(1f)) {
                    MyCityAppTopBar(
                        title = placeTitle?.title ?: Screens.COFFEE_SHOP_DETAILS.title,
                        canNavigateBack = true,
                        navigateBack = { selectedPlace = null },
                        modifier = Modifier.clip(
                            shape = RoundedCornerShape(
                                topStart = dimensionResource(id = R.dimen.card_corner_radius),
                                topEnd = dimensionResource(id = R.dimen.card_corner_radius)
                            )
                        )
                    )
                    when (places?.screen) {
                        Screens.COFFEE_SHOPS -> {
                            CoffeeDetailScreen(coffeeShop = selectedPlace as CoffeeShop)
                            placeTitle = Screens.COFFEE_SHOP_DETAILS
                        }

                        Screens.RESTAURANTS -> {
                            RestaurantDetailScreen(restaurant = selectedPlace as Restaurant)
                            placeTitle = Screens.RESTAURANT_DETAILS
                        }

                        Screens.KID_FRIENDLY_PLACES -> {
                            KidFriendlyPlaceDetailScreen(kidFriendlyPlace = selectedPlace as KidFriendlyPlace)
                            placeTitle = Screens.KID_FRIENDLY_PLACE_DETAILS
                        }

                        Screens.PARKS -> {
                            ParkDetailsScreen(park = selectedPlace as Park)
                            placeTitle = Screens.PARK_DETAILS
                        }

                        Screens.SHOPPING_CENTER_DETAILS -> {
                            ShoppingCenterDetailScreen(shoppingCenter = selectedPlace as ShoppingCenter)
                            placeTitle = Screens.SHOPPING_CENTER_DETAILS
                        }

                        else -> {
                            selectedPlace = null
                        }
                    }
                }
            }
        }
    } else {
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)),
            exit = fadeOut(),
            modifier = modifier,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = dimensionResource(id = R.dimen.padding_small)
                )
            ) {
                for (i in recommendations.indices) {
                    RecommendationItem(
                        recommendation = recommendations[i],
                        onClick = { selectedRecommendation -> onClick(selectedRecommendation) },
                        modifier = Modifier.animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = Spring.StiffnessVeryLow,
                                    dampingRatio = Spring.DampingRatioLowBouncy
                                ),
                                initialOffsetY = { it * (i + 1) } // staggered entrance
                            )
                        )
                    )
                }
            }
        }
    }
}

@Preview(name = "Light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun RecommendationScreenPreview() {
    MyCityTheme {
        RecommendationScreen(
            recommendations = RecommendationDataProvider.recommendations,
            contentType = MyCityContentType.LIST_ONLY,
            placeUiState = PlaceUiState(),
            onClick = { }
        )
    }
}