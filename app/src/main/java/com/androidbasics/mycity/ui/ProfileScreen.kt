package com.androidbasics.mycity.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Text(
        text = "Coming soon!",
        modifier = modifier.wrapContentHeight(),
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center
    )
}

@Preview(name = "Light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ProfileScreenPreview() {
    MyCityTheme {
        ProfileScreen()
    }
}