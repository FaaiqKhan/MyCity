package com.androidbasics.mycity.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.androidbasics.mycity.R

@Composable
fun PlaceDescription(@StringRes descriptionId: Int) {
    Column(
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
    ) {
        Text(
            text = "Description",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = stringResource(id = descriptionId),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}