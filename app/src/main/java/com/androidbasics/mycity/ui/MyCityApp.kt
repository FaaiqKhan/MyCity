package com.androidbasics.mycity.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.*
import com.androidbasics.mycity.data.local.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
) {
    val viewModel: PlaceViewModel = viewModel()
    val placeUiState = viewModel.uiState.collectAsState().value

    val navController: NavHostController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        Screens.valueOf(backStackEntry?.destination?.route ?: Screens.RECOMMENDATIONS.name)

    val screenModifier = Modifier
        .fillMaxHeight()
        .padding(all = dimensionResource(R.dimen.padding_small))

    Scaffold(
        topBar = {
            MyCityAppTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateBack = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.RECOMMENDATIONS.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screens.RECOMMENDATIONS.name) {
                RecommendationScreen(
                    recommendations = RecommendationDataProvider.recommendations,
                    modifier = screenModifier
                ) { place -> navController.navigate(route = place.screen.name) }
            }
            composable(route = Screens.COFFEE_SHOPS.name) {
                PlaceScreen(
                    places = CoffeeShopDataProvider.coffees,
                    modifier = screenModifier
                ) { selectedPlace ->
                    val coffeePlace =
                        CoffeeShopDataProvider.coffees.find { it.name == selectedPlace.name }
                    viewModel.updatePlace(coffeePlace!!)
                    navController.navigate(route = Screens.COFFEE_SHOP_DETAILS.name)
                }
            }
            composable(route = Screens.RESTAURANTS.name) {
                PlaceScreen(
                    places = RestaurantDataProvider.restaurants,
                    modifier = screenModifier
                ) { selectedPlace ->
                    val restaurantPlace =
                        RestaurantDataProvider.restaurants.find { it.name == selectedPlace.name }
                    viewModel.updatePlace(restaurantPlace!!)
                    navController.navigate(route = Screens.RESTAURANT_DETAILS.name)
                }
            }
            composable(route = Screens.KID_FRIENDLY_PLACES.name) {
                PlaceScreen(
                    places = KidFriendlyPlaceDataProvider.kidFriendlyPlaces,
                    modifier = screenModifier
                ) { selectedPlace ->
                    val kidFriendlyPlace =
                        KidFriendlyPlaceDataProvider.kidFriendlyPlaces.find { it.name == selectedPlace.name }
                    viewModel.updatePlace(kidFriendlyPlace!!)
                    navController.navigate(route = Screens.KID_FRIENDLY_PLACE_DETAILS.name)
                }
            }
            composable(route = Screens.PARKS.name) {
                PlaceScreen(
                    places = ParkDataProvider.parks,
                    modifier = screenModifier
                ) { selectedPlace ->
                    val park = ParkDataProvider.parks.find { it.name == selectedPlace.name }
                    viewModel.updatePlace(park!!)
                    navController.navigate(route = Screens.PARK_DETAILS.name)
                }
            }
            composable(route = Screens.SHOPPING_CENTERS.name) {
                PlaceScreen(
                    places = ShoppingCenterDataProvider.shoppingCenters,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(all = dimensionResource(R.dimen.padding_small))
                ) { selectedPlace ->
                    val shoppingCenter =
                        ShoppingCenterDataProvider.shoppingCenters.find { it.name == selectedPlace.name }
                    viewModel.updatePlace(shoppingCenter!!)
                    navController.navigate(route = Screens.SHOPPING_CENTER_DETAILS.name)
                }
            }
            composable(route = Screens.COFFEE_SHOP_DETAILS.name) {
                CoffeeDetailScreen(
                    coffeeShop = placeUiState.place as CoffeeShop,
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = Screens.RESTAURANT_DETAILS.name) {
                RestaurantDetailScreen(
                    restaurant = placeUiState.place as Restaurant,
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = Screens.KID_FRIENDLY_PLACE_DETAILS.name) {
                KidFriendlyPlaceDetailScreen(
                    kidFriendlyPlace = placeUiState.place as KidFriendlyPlace,
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = Screens.PARK_DETAILS.name) {
                ParkDetailsScreen(
                    park = placeUiState.place as Park,
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(route = Screens.SHOPPING_CENTER_DETAILS.name) {
                ShoppingCenterDetailScreen(
                    shoppingCenter = placeUiState.place as ShoppingCenter,
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppTopBar(
    currentScreen: Screens,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(id = currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}