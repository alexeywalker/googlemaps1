package com.example.googlemaps1.presentation

import com.google.maps.android.compose.MapProperties
import com.example.googlemaps1.domain.model.ParkingSpot

data class MapState(
    val properties: MapProperties = MapProperties(
        isMyLocationEnabled = true,
        maxZoomPreference = 21.0f,
        minZoomPreference = 3.0f
    ),
    val parkingSpots: List<ParkingSpot> = emptyList(),
)
