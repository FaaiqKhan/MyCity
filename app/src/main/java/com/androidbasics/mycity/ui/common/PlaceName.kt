package com.androidbasics.mycity.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.androidbasics.mycity.R

@Composable
fun PlaceName(@StringRes nameId: Int) {
    Text(
        text = stringResource(id = nameId),
        style = MaterialTheme.typography.labelLarge,
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_medium)),
        color = MaterialTheme.colorScheme.onSurface
    )
}