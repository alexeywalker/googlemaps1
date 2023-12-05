package com.example.googlemaps1.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlemaps1.domain.model.MSpot
import com.example.googlemaps1.domain.repository.MSpotRepository
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: MSpotRepository
) : ViewModel() {

    var state by mutableStateOf(MapState())
    init {
        viewModelScope.launch {
            repository.getMSpots().collectLatest { spots ->
                state = state.copy(
                    mSpots = spots
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.Form -> {

            }
            is MapEvent.OnMapLongClick -> {
                val database = FirebaseDatabase.getInstance()
                val myRef = database.getReference("location")
                viewModelScope.launch {
                    myRef.setValue(MSpot(
                        event.latLng.latitude,
                        event.latLng.longitude
                    ))
                    repository.insertMSpot(
                        MSpot(
                            event.latLng.latitude,
                            event.latLng.longitude
                        )
                    )
                }
            }
            is MapEvent.OnInfoWindowLongClick -> {

                viewModelScope.launch {
                    repository.deleteMSpot(event.spot)
                }
            }
        }
    }
}