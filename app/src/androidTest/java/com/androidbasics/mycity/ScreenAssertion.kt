package com.androidbasics.mycity

import androidx.navigation.NavController
import junit.framework.TestCase

fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    TestCase.assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}