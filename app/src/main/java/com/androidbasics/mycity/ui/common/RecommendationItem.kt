package com.androidbasics.mycity.ui.common

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import com.androidbasics.mycity.R
import com.androidbasics.mycity.data.Recommendation
import com.androidbasics.mycity.data.local.RecommendationDataProvider
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun RecommendationItem(recommendation: Recommendation, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = null,
                modifier = Modifier.height(
                    height = dimensionResource(id = R.dimen.card_image_height)
                )
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
            Text(text = stringResource(id = recommendation.name))
        }
    }
}

@Preview(name = "Light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun RecommendationItemPreview() {
    MyCityTheme {
        RecommendationItem(recommendation = RecommendationDataProvider.defaultRecommendation)
    }
}