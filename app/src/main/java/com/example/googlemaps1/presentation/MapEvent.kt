package com.example.googlemaps1.presentation

import com.google.android.gms.maps.model.LatLng
import com.example.googlemaps1.domain.model.ParkingSpot

sealed class MapEvent {
    data class OnMapLongClick(val latLng: LatLng): MapEvent()
    data class OnInfoWindowLongClick(val spot: ParkingSpot): MapEvent()
}
