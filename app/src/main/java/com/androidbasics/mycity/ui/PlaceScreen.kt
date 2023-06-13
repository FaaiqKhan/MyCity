package com.androidbasics.mycity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.interfaces.Place
import com.androidbasics.mycity.data.local.*
import com.androidbasics.mycity.ui.common.PlaceItem
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun PlaceScreen(
    places: List<Place>,
    modifier: Modifier = Modifier,
    onClick: (selectedPlace: Place) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        items(places.size) {
            PlaceItem(
                suggestedPlace = places[it],
                onClick = { selectedPlace -> onClick(selectedPlace) })
        }
    }
}

@Preview(name = "Coffee light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Coffee dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CoffeeShopsScreenPreview() {
    MyCityTheme {
        PlaceScreen(places = CoffeeShopDataProvider.coffees) { }
    }
}

@Preview(name = "Restaurant light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Restaurant dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun RestaurantScreenPreview() {
    MyCityTheme {
        PlaceScreen(places = RestaurantDataProvider.restaurants) { }
    }
}

@Preview(name = "Kid friendly places light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Kid friendly places dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun KidFriendlyPlacesScreenPreview() {
    MyCityTheme {
        PlaceScreen(places = KidFriendlyPlaceDataProvider.kidFriendlyPlaces) { }
    }
}

@Preview(name = "Parks light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Parks dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ParksScreenPreview() {
    MyCityTheme {
        PlaceScreen(places = ParkDataProvider.parks) { }
    }
}

@Preview(name = "Shopping centers light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Shopping centers dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ShoppingCentersScreenPreview() {
    MyCityTheme {
        PlaceScreen(places = ShoppingCenterDataProvider.shoppingCenters) { }
    }
}
