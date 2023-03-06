package com.esatgozcu.roomdbexample.di

import com.esatgozcu.roomdbexample.database.CarDAO
import com.esatgozcu.roomdbexample.repository.CarRepository
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
    fun provideCarRepository(carDao: CarDAO): CarRepository {
        return CarRepository(carDao)
    }
}