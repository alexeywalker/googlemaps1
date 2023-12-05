package com.example.googlemaps1.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MSpotEntity::class],
    version = 1
)
abstract class MSpotDatabase: RoomDatabase() {

    abstract val dao: MSpotDao
}