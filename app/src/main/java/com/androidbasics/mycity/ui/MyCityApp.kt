package com.androidbasics.mycity.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.Screens
import com.androidbasics.mycity.data.local.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        Screens.valueOf(backStackEntry?.destination?.route ?: Screens.RECOMMENDATIONS.name)

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
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(all = dimensionResource(id = R.dimen.padding_small))
                ) { /* TODO: navigate to screen according to selectedRecommendation */  }
            }
            composable(route = Screens.COFFEE_SHOPS.name) {}
            composable(route = Screens.RESTAURANTS.name) {}
            composable(route = Screens.KID_FRIENDLY_PLACES.name) {}
            composable(route = Screens.PARKS.name) {}
            composable(route = Screens.SHOPPING_CENTERS.name) {}
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