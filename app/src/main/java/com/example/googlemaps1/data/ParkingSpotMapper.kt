package com.example.googlemaps1.data

import com.example.googlemaps1.domain.model.ParkingSpot

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot {
    return ParkingSpot(
        lat = lat,
        lng = lng,
        id = id
    )
}

fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}