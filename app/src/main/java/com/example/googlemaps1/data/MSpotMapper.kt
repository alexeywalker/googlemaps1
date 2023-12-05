package com.example.googlemaps1.data

import com.example.googlemaps1.domain.model.MSpot

fun MSpotEntity.toMSpot(): MSpot {
    return MSpot(
        lat = lat,
        lng = lng,
        id = id
    )
}

fun MSpot.toMSpotEntity(): MSpotEntity {
    return MSpotEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}