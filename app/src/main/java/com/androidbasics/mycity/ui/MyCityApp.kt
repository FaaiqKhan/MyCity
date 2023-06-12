package com.androidbasics.mycity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.androidbasics.mycity.data.Screens
import com.androidbasics.mycity.data.local.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.RECOMMENDATIONS.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screens.RECOMMENDATIONS.name) {}
            composable(route = Screens.COFFEE_SHOPS.name) {}
            composable(route = Screens.RESTAURANTS.name) {}
            composable(route = Screens.KID_FRIENDLY_PLACES.name) {}
            composable(route = Screens.PARKS.name) {}
            composable(route = Screens.SHOPPING_CENTERS.name) {}
        }
    }
}