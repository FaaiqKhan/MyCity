package com.androidbasics.mycity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.KidFriendlyPlace
import com.androidbasics.mycity.data.local.KidFriendlyPlaceDataProvider
import com.androidbasics.mycity.ui.common.*
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun KidFriendlyPlaceDetailScreen(
    kidFriendlyPlace: KidFriendlyPlace,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surfaceVariant),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        DetailScreenImageViewer(imageId = kidFriendlyPlace.image)
        PlaceName(nameId = kidFriendlyPlace.name)
        Text(
            text = "Ticket required -> ${if (kidFriendlyPlace.hasTicket) "Yes" else "No"}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
        )
        if (kidFriendlyPlace.hasTicket) {
            Text(
                text = "Ticket price -> ${kidFriendlyPlace.ticketPrice} \u20AC",
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            )
        }
        Text(
            text = "Animals -> ${if (kidFriendlyPlace.hasAnimals) "Yes" else "No"}",
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
        )
        PlaceDescription(descriptionId = kidFriendlyPlace.description)
    }
}

@Preview(name = "Light theme", showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun KidFriendlyPlaceDetailScreenPreview() {
    MyCityTheme {
        KidFriendlyPlaceDetailScreen(kidFriendlyPlace = KidFriendlyPlaceDataProvider.defaultKidFriendlyPlace)
    }
}