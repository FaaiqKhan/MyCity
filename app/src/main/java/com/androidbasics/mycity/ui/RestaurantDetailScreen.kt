package com.androidbasics.mycity.ui

import android.content.res.Configuration
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
import com.androidbasics.mycity.data.Restaurant
import com.androidbasics.mycity.data.local.RestaurantDataProvider
import com.androidbasics.mycity.ui.common.*
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun RestaurantDetailScreen(restaurant: Restaurant, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.surfaceVariant),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        DetailScreenImageViewer(imageId = restaurant.image)
        PlaceName(nameId = restaurant.name)
        Column(
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
        ) {
            Text(
                text = "Available food types ",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            restaurant.availableFoodType.forEach {
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
                text = "Available order weight",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            restaurant.availableOrderWeight.forEach {
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
        PlaceDescription(descriptionId = restaurant.description)
    }
}

@Preview(name = "Light theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RestaurantDetailScreenPreview() {
    MyCityTheme {
        RestaurantDetailScreen(restaurant = RestaurantDataProvider.defaultRestaurant)
    }
}