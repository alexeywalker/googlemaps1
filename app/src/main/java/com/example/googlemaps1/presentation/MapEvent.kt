package com.example.googlemaps1.presentation

import com.example.googlemaps1.domain.model.MSpot
import com.google.android.gms.maps.model.LatLng

sealed class MapEvent {
    data object Form : MapEvent()
    data class OnMapLongClick(val latLng: LatLng) : MapEvent()
    data class OnInfoWindowLongClick(val spot: MSpot) : MapEvent()
}
