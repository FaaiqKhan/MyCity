package com.androidbasics.mycity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.CoffeeShop
import com.androidbasics.mycity.data.local.CoffeeShopDataProvider
import com.androidbasics.mycity.ui.common.*
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun CoffeeDetailScreen(coffeeShop: CoffeeShop, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surfaceVariant),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
    ) {
        DetailScreenImageViewer(imageId = coffeeShop.image)
        PlaceName(nameId = coffeeShop.name)
        Column(
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = "Available coffee ",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            coffeeShop.availableCoffeeType.forEach {
                Row(
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.padding(
                            end = dimensionResource(
                                id = R.dimen.padding_small
                            )
                        ),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = "Available size",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            coffeeShop.availableCoffeeSize.forEach {
                Row(
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.padding(
                            end = dimensionResource(
                                id = R.dimen.padding_small
                            )
                        ),
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
        PlaceDescription(descriptionId = coffeeShop.description)
    }
}

@Preview(name = "Light theme", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CoffeeDetailScreenPreview() {
    MyCityTheme {
        CoffeeDetailScreen(coffeeShop = CoffeeShopDataProvider.defaultCoffee)
    }
}