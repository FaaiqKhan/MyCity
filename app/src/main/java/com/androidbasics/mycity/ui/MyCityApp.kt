package com.androidbasics.mycity.ui

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.*
import com.androidbasics.mycity.data.local.*
import com.androidbasics.mycity.utils.Utils.MyCityContentType
import com.androidbasics.mycity.utils.Utils.MyCityNavigationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    myCityViewModel: PlaceViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val placeUiState = myCityViewModel.uiState.collectAsState().value
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen =
        Screens.valueOf(backStackEntry?.destination?.route ?: Screens.RECOMMENDATIONS.name)

    val screenModifier = Modifier
        .fillMaxHeight()
        .padding(all = dimensionResource(R.dimen.padding_small))

    val navigationType: MyCityNavigationType
    val contentType: MyCityContentType

    val navigationItemContentList = listOf(
        NavigationItemContent(
            itemType = NavigationItemType.HOME,
            icon = Icons.Default.Home,
            text = stringResource(id = R.string.home)
        ),
        NavigationItemContent(
            itemType = NavigationItemType.PROFILE,
            icon = Icons.Default.Person,
            text = stringResource(id = R.string.profile)
        ),
        NavigationItemContent(
            itemType = NavigationItemType.INFO,
            icon = Icons.Default.Info,
            text = stringResource(id = R.string.info)
        )
    )

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium -> {
            navigationType = MyCityNavigationType.NAVIGATION_RAIL
            contentType = MyCityContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Expanded -> {
            navigationType = MyCityNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = MyCityContentType.LIST_AND_DETAIL
        }

        else -> {
            navigationType = MyCityNavigationType.BOTTOM_NAVIGATION
            contentType = MyCityContentType.LIST_ONLY
        }
    }

    Scaffold(
        topBar = {
            MyCityAppTopBar(
                title = when (placeUiState.currentNavigationItem) {
                    NavigationItemType.INFO -> R.string.info
                    NavigationItemType.PROFILE -> R.string.profile
                    else -> currentScreen.title
                },
                canNavigateBack = when (placeUiState.currentNavigationItem) {
                  NavigationItemType.INFO, NavigationItemType.PROFILE -> false
                  else -> navController.previousBackStackEntry != null
                },
                navigateBack = { navController.popBackStack() }
            )
        },
        bottomBar = {
            AnimatedVisibility(visible = navigationType == MyCityNavigationType.BOTTOM_NAVIGATION) {
                val bottomNavigationContentDescription =
                    stringResource(id = R.string.navigation_bottom)
                BottomNavigationBar(
                    currentItem = placeUiState.currentNavigationItem,
                    navigationItemContentList = navigationItemContentList,
                    onTabPress = {
                        myCityViewModel.updateNavigationItem(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(bottomNavigationContentDescription)
                )
            }
        }
    ) { innerPadding ->
        Application(
            navHostComposable = {
                when (placeUiState.currentNavigationItem) {
                    NavigationItemType.PROFILE -> {
                        ProfileScreen(
                            modifier = Modifier
                                .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
                                .fillMaxHeight()
                                .testTag(stringResource(id = R.string.profile))
                        )
                    }

                    NavigationItemType.INFO -> {
                        InfoScreen(
                            modifier = Modifier
                                .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
                                .fillMaxHeight()
                        )
                    }

                    else -> {
                        NavigationHost(
                            navController = navController,
                            modifier = screenModifier,
                            viewModel = myCityViewModel,
                            placeUiState = placeUiState,
                            contentType = contentType
                        )
                    }
                }
            },
            innerPadding = innerPadding,
            navigationType = navigationType,
            viewModel = myCityViewModel,
            contentList = navigationItemContentList,
            uiState = placeUiState
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Application(
    navHostComposable: @Composable () -> Unit,
    innerPadding: PaddingValues,
    navigationType: MyCityNavigationType,
    viewModel: PlaceViewModel,
    contentList: List<NavigationItemContent>,
    uiState: PlaceUiState
) {
    AnimatedVisibility(
        visible = navigationType == MyCityNavigationType.BOTTOM_NAVIGATION,
        modifier = Modifier.padding(innerPadding)
    ) {
        navHostComposable()
    }
    AnimatedVisibility(
        visible = navigationType == MyCityNavigationType.NAVIGATION_RAIL,
        modifier = Modifier.padding(innerPadding)
    ) {
        val railNavigationDescriptionContent = stringResource(id = R.string.navigation_rail)
        Row {
            RailNavigationBar(
                currentItem = uiState.currentNavigationItem,
                onTabPress = {
                    viewModel.updateNavigationItem(it)
                },
                navigationItemContentList = contentList,
                modifier = Modifier
                    .testTag(railNavigationDescriptionContent)
            )
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(dimensionResource(id = R.dimen.divider_width))
            )
            navHostComposable()
        }
    }
    AnimatedVisibility(
        visible = navigationType == MyCityNavigationType.PERMANENT_NAVIGATION_DRAWER,
        modifier = Modifier.padding(innerPadding)
    ) {
        val navigationDrawerContentDescription =
            stringResource(id = R.string.navigation_drawer)
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(
                    modifier = Modifier.width(dimensionResource(id = R.dimen.drawer_width))
                ) {
                    NavigationDrawerContent(
                        currentItem = uiState.currentNavigationItem,
                        onTabPress = { viewModel.updateNavigationItem(it) },
                        navigationItemContentList = contentList,
                        modifier = Modifier
                            .wrapContentWidth()
                            .fillMaxHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                            .padding(dimensionResource(R.dimen.drawer_padding_content))
                            .testTag(navigationDrawerContentDescription)
                    )
                }
            }
        ) {
            navHostComposable()
        }
    }
}

@Composable
private fun NavigationHost(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: PlaceViewModel,
    placeUiState: PlaceUiState,
    contentType: MyCityContentType
) {
    NavHost(
        navController = navController,
        startDestination = Screens.RECOMMENDATIONS.name,
    ) {
        composable(route = Screens.RECOMMENDATIONS.name) {
            RecommendationScreen(
                recommendations = RecommendationDataProvider.recommendations,
                modifier = modifier,
                contentType = contentType,
                placeUiState = placeUiState,
                onClick = { place ->
                    if (contentType == MyCityContentType.LIST_AND_DETAIL) {
                        viewModel.updatePlace(place = place)
                    } else {
                        navController.navigate(route = place.screen.name)
                    }
                }
            )
        }
        composable(route = Screens.COFFEE_SHOPS.name) {
            PlaceScreen(
                places = CoffeeShopDataProvider.coffees,
                modifier = modifier
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
                modifier = modifier
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
                modifier = modifier
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
                modifier = modifier
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppTopBar(
    @StringRes title: Int,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(title)) },
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
        },
        modifier = modifier
    )
}

@Composable
fun BottomNavigationBar(
    currentItem: NavigationItemType,
    onTabPress: (bottomNavItemType: NavigationItemType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        navigationItemContentList.forEach {
            NavigationBarItem(
                selected = currentItem == it.itemType,
                onClick = { onTabPress(it.itemType) },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.text
                    )
                }
            )
        }
    }
}

@Composable
fun RailNavigationBar(
    currentItem: NavigationItemType,
    onTabPress: (bottomNavItemType: NavigationItemType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationRail(modifier = modifier) {
        navigationItemContentList.forEach {
            NavigationRailItem(
                selected = currentItem == it.itemType,
                onClick = { onTabPress(it.itemType) },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.text
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavigationDrawerContent(
    currentItem: NavigationItemType,
    onTabPress: (bottomNavItemType: NavigationItemType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        navigationItemContentList.forEach {
            NavigationDrawerItem(
                label = {
                    Text(
                        text = it.text,
                        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.drawer_padding_header))
                    )
                },
                selected = currentItem == it.itemType,
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.text
                    )
                },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                onClick = { onTabPress(it.itemType) }
            )
        }
    }
}