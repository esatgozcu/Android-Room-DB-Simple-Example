package com.esatgozcu.roomdbexample.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.esatgozcu.roomdbexample.database.Car
import com.esatgozcu.roomdbexample.database.CarDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarRepository(private val carDao: CarDAO) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allCars = MutableLiveData<List<Car>>()

    fun addCar(newCar: Car, completion: () -> Unit) {
        coroutineScope.launch(Dispatchers.IO) {
            carDao.addCar(newCar)
            completion()
        }
    }

    fun updateCarDetails(updateCar: Car, completion: () -> Unit) {
        coroutineScope.launch(Dispatchers.IO) {
            carDao.updateCar(updateCar)
            completion()
        }
    }

    fun getAllCars() {
        coroutineScope.launch(Dispatchers.IO) {
            allCars.postValue(carDao.getAllCars())
        }
    }

    fun deleteCar(car: Car, completion: () -> Unit) {
        coroutineScope.launch(Dispatchers.IO) {
            carDao.deleteCar(car)
            completion()
        }
    }

    fun findCarById(clrID: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            val car = carDao.findCarById(clrID)
            Log.d("CLICKED_ITEM",car.carName)
        }
    }
}