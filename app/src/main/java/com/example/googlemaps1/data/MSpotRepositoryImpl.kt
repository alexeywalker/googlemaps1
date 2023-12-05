package com.example.googlemaps1.data

import com.example.googlemaps1.domain.model.MSpot
import com.example.googlemaps1.domain.repository.MSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MSpotRepositoryImpl(
    private val dao: MSpotDao
): MSpotRepository {

    override suspend fun insertMSpot(spot: MSpot) {
        dao.insertParkingSpot(spot.toMSpotEntity())
    }

    override suspend fun deleteMSpot(spot: MSpot) {
        dao.deleteParkingSpot(spot.toMSpotEntity())
    }

    override fun getMSpots(): Flow<List<MSpot>> {
        return dao.getParkingSpots().map { spots ->
            spots.map { it.toMSpot() }
        }
    }
}