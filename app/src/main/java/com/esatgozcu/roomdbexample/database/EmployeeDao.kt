package com.esatgozcu.roomdbexample.database

import androidx.room.*

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM colors")
    fun getAllEmployees(): List<Color>

    @Query("SELECT * FROM colors WHERE colorName = :empId")
    fun findEmployeeById(empId: String): Color

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addColor(employee: Color)

    @Update
    suspend fun updateColor(employee: Color)

    @Delete
    suspend fun deleteColor(employee: Color)
}