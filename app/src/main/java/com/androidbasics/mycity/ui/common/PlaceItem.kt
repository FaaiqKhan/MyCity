package com.androidbasics.mycity.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.*
import com.androidbasics.mycity.data.interfaces.Place
import com.androidbasics.mycity.data.local.CoffeeShopDataProvider
import com.androidbasics.mycity.ui.theme.MyCityTheme
import com.androidbasics.mycity.utils.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceItem(
    suggestedPlace: Place,
    modifier: Modifier = Modifier,
    onClick: (place: Place) -> Unit,
) {
    Card(
        modifier = modifier.height(dimensionResource(id = R.dimen.card_image_height)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius)),
        onClick = { onClick(suggestedPlace) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = suggestedPlace.image), contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.card_image_height)),
                contentScale = ContentScale.FillHeight
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = suggestedPlace.name),
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = stringResource(id = suggestedPlace.description),
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium))
                )
            }
        }
    }
}

@Preview(name = "Light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun SuggestionItemPreview() {
    MyCityTheme {
        PlaceItem(
            suggestedPlace = CoffeeShopDataProvider.defaultCoffee,
            onClick = { }
        )
    }
}