package com.androidbasics.mycity.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.androidbasics.mycity.R

@Composable
fun DetailScreenImageViewer(@DrawableRes imageId: Int) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.card_image_height_details)),
    )
}