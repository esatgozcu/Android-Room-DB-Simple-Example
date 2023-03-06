package com.esatgozcu.roomdbexample.database

import androidx.room.*

@Dao
interface CarDAO {

    @Query("SELECT * FROM cars")
    fun getAllCars(): List<Car>

    @Query("SELECT * FROM cars WHERE carName = :crId")
    fun findCarById(crId: String): Car

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCar(car: Car)

    @Update
    suspend fun updateCar(car: Car)

    @Delete
    suspend fun deleteCar(car: Car)
}