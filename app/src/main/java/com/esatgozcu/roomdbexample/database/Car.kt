package com.esatgozcu.roomdbexample.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cars")
data class Car(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "carId")
    var id: Int = 0,
    @ColumnInfo(name = "carName")
    var carName: String,
) : Parcelable