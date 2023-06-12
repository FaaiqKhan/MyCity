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
import com.androidbasics.mycity.data.Recommendation
import com.androidbasics.mycity.data.local.RecommendationDataProvider
import com.androidbasics.mycity.ui.common.RecommendationItem
import com.androidbasics.mycity.ui.theme.MyCityTheme

@Composable
fun RecommendationScreen(
    recommendations: List<Recommendation>,
    modifier: Modifier = Modifier,
    onClick: (selectedRecommendation: Recommendation) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        items(count = recommendations.size) {
            RecommendationItem(
                recommendation = recommendations[it],
                onClick = { selectedRecommendation -> onClick(selectedRecommendation) })
        }
    }
}

@Preview(name = "Light theme", showBackground = false, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Dark theme", showBackground = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun RecommendationScreenPreview() {
    MyCityTheme {
        RecommendationScreen(recommendations = RecommendationDataProvider.recommendations) {}
    }
}