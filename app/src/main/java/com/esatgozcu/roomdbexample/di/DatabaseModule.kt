package com.esatgozcu.roomdbexample.di

import android.content.Context
import androidx.room.Room
import com.esatgozcu.roomdbexample.database.CarDAO
import com.esatgozcu.roomdbexample.database.CarRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object DatabaseModule {
    @Provides
    fun provideCarDAO(appDatabase: CarRoomDatabase): CarDAO {
        return appDatabase.carDAO()
    }
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): CarRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CarRoomDatabase::class.java,
            "AppDB"
        ).build()
    }
}