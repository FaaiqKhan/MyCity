package com.androidbasics.mycity.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.ShoppingCenter
import com.androidbasics.mycity.data.local.ShoppingCenterDataProvider
import com.androidbasics.mycity.ui.common.*
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun ShoppingCenterDetailScreen(shoppingCenter: ShoppingCenter, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        DetailScreenImageViewer(imageId = shoppingCenter.image)
        PlaceName(nameId = shoppingCenter.name)
        Text(
            text = "Ticket required -> ${if (shoppingCenter.hasFoodCort) "Yes" else "No"}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
        )
        Text(
            text = "Ticket required -> ${if (shoppingCenter.hasJewelryShops) "Yes" else "No"}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
        )
        PlaceDescription(descriptionId = shoppingCenter.description)
    }
}

@Preview(name = "Light theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ShoppingCenterDetailScreenPreview() {
    MyCityTheme {
        ShoppingCenterDetailScreen(shoppingCenter = ShoppingCenterDataProvider.defaultShoppingCenter)
    }
}

