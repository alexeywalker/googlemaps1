package com.example.googlemaps1.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlemaps1.domain.model.ParkingSpot
import com.example.googlemaps1.domain.repository.ParkingSpotRepository
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: ParkingSpotRepository
) : ViewModel() {

    var state by mutableStateOf(MapState())
    init {
        viewModelScope.launch {
            repository.getParkingSpots().collectLatest { spots ->
                state = state.copy(
                    parkingSpots = spots
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.OnMapLongClick -> {
                val database = FirebaseDatabase.getInstance("https://helpua-538fa-default-rtdb.europe-west1.firebasedatabase.app")
                val myRef = database.getReference("location")
                viewModelScope.launch {
                    myRef.setValue(ParkingSpot(
                        event.latLng.latitude,
                        event.latLng.longitude
                    ))
//                    repository.insertParkingSpot(
//                        ParkingSpot(
//                            event.latLng.latitude,
//                            event.latLng.longitude
//                        )
//                    )
                }
            }
            is MapEvent.OnInfoWindowLongClick -> {

                viewModelScope.launch {
                    repository.deleteParkingSpot(event.spot)
                }
            }
        }
    }
}