package com.example.googlemaps1.di

import android.app.Application
import androidx.room.Room
import com.example.googlemaps1.data.MSpotDatabase
import com.example.googlemaps1.data.MSpotRepositoryImpl
import com.example.googlemaps1.domain.repository.MSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMSpotDatabase(app: Application): MSpotDatabase {
        return Room.databaseBuilder(
            app,
            MSpotDatabase::class.java,
            "parking_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMSpotRepository(db: MSpotDatabase): MSpotRepository {
        return MSpotRepositoryImpl(db.dao)
    }
}