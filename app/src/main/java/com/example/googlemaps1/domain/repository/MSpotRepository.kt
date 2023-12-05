package com.example.googlemaps1.domain.repository

import com.example.googlemaps1.domain.model.MSpot
import kotlinx.coroutines.flow.Flow

interface MSpotRepository {

    suspend fun insertMSpot(spot: MSpot)

    suspend fun deleteMSpot(spot: MSpot)

    fun getMSpots(): Flow<List<MSpot>>
}