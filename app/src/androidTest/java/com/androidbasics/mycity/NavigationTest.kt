package com.androidbasics.mycity

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.androidbasics.mycity.data.Screens
import com.androidbasics.mycity.data.local.CoffeeShopDataProvider
import com.androidbasics.mycity.ui.MyCityApp
import org.junit.*

class NavigationTest {

    // Using ComponentActivity because it is an empty activity, rather then actual activity
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupMyCityNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MyCityApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }

    @Test
    fun myCityNavHost_verifyRecommendationDestination() {
        navController.assertCurrentRouteName(Screens.RECOMMENDATIONS.name)
    }

    @Test
    fun myCityNavHost_verifyBackButtonNotShownInRecommendation() {
        val backButton = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backButton).assertDoesNotExist()
    }

    @Test
    fun myCityNavHost_verifyNavigationToCoffeeList() {
        composeTestRule.onNodeWithStringId(R.string.coffee_shop).performClick()

        // Check back button is visible
        val backButton = composeTestRule.activity.getString(R.string.back_button)
        composeTestRule.onNodeWithContentDescription(backButton).assertIsDisplayed()

        // Check list of coffee displayed
        composeTestRule.onNodeWithTagForStringId(CoffeeShopDataProvider.defaultCoffee.name)
            .assertIsDisplayed()

        // Click on coffee to view description
        composeTestRule.onNodeWithTagForStringId(CoffeeShopDataProvider.defaultCoffee.name).performClick()

        // Check detail screen is displayed
        composeTestRule.onNodeWithStringId(R.string.coffee_shop_details).assertExists()
    }
}