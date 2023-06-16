package com.androidbasics.mycity

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.androidbasics.mycity.ui.MyCityApp
import org.junit.Rule
import org.junit.Test

class MyCityAppTest {

    // Using ComponentActivity because it is an empty activity, rather then actual activity
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    @TestAnnotations.TestCompactWidth
    fun compactDevice_verifyUsingBottomNavigation() {
        composeTestRule.setContent {
            MyCityApp(windowSize = WindowWidthSizeClass.Compact)
        }

        // Checking bottom navigation is displayed
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_bottom).assertExists()

        // Checking navigation to profile screen
        composeTestRule
    }

    @Test
    @TestAnnotations.TestMediumWidth
    fun mediumDevice_verifyUsingNavigationRail() {
        composeTestRule.setContent {
            MyCityApp(windowSize = WindowWidthSizeClass.Medium)
        }

        // Checking side navigation is displayed
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_rail).assertExists()
    }

    @Test
    @TestAnnotations.TestExpandedWidth
    fun expandedDevice_verifyUsingPermanentNavigation() {
        composeTestRule.setContent {
            MyCityApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        // Checking permanent side navigation is displayed
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_drawer).assertExists()
    }

    @Test
    fun places_visible_onClick() {
        composeTestRule.setContent {
            MyCityApp(windowSize = WindowWidthSizeClass.Compact)
        }

    }
}