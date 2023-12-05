package com.example.googlemaps1.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MSpotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParkingSpot(spot: MSpotEntity)

    @Delete
    suspend fun deleteParkingSpot(spot: MSpotEntity)

    @Query("SELECT * FROM mspotentity")
    fun getParkingSpots(): Flow<List<MSpotEntity>>
}