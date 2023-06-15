package com.androidbasics.mycity.ui

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.androidbasics.mycity.R

@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    val scroll = rememberScrollState(0)
    Text(
        text = stringResource(id = R.string.app_info),
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier.verticalScroll(scroll)
    )
}