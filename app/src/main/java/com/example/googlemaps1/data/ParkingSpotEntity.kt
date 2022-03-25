package com.example.googlemaps1.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ParkingSpotEntity(
    val lat: Double,
    val lng: Double,
    @PrimaryKey val id: Int? = null
)
