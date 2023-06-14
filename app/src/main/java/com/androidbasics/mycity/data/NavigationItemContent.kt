package com.androidbasics.mycity.data

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItemContent(
    val itemType: NavigationItemType,
    val icon: ImageVector,
    val text: String
)
