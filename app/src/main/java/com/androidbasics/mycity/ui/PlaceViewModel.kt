package com.androidbasics.mycity.ui

import androidx.lifecycle.ViewModel
import com.androidbasics.mycity.data.NavigationItemType
import com.androidbasics.mycity.data.PlaceUiState
import com.androidbasics.mycity.data.interfaces.Place
import kotlinx.coroutines.flow.*

class PlaceViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PlaceUiState())
    val uiState: StateFlow<PlaceUiState> = _uiState

    fun updatePlace(place: Place) {
        _uiState.update { currentPlace -> currentPlace.copy(place = place) }
    }

    fun updateNavigationItem(navigationItem: NavigationItemType) {
        _uiState.update { currentPlace -> currentPlace.copy(currentNavigationItem = navigationItem) }
    }
}