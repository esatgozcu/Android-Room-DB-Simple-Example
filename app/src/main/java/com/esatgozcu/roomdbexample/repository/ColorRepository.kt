package com.esatgozcu.roomdbexample.repository

import androidx.lifecycle.MutableLiveData
import com.esatgozcu.roomdbexample.database.Car
import com.esatgozcu.roomdbexample.database.CarDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarRepository(private val carDao: CarDAO) {

    val allCars = MutableLiveData<List<Car>>()
    val foundCar = MutableLiveData<Car>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addCar(newCar: Car) {
        coroutineScope.launch(Dispatchers.IO) {
            carDao.addCar(newCar)
        }
    }

    fun updateCarDetails(updateCar: Car) {
        coroutineScope.launch(Dispatchers.IO) {
            carDao.updateCar(updateCar)
        }
    }

    fun getAllCars() {
        coroutineScope.launch(Dispatchers.IO) {
            allCars.postValue(carDao.getAllCars())
        }
    }

    fun deleteCar(car: Car) {
        coroutineScope.launch(Dispatchers.IO) {
            carDao.deleteCar(car)
        }
    }

    fun findCarById(clrID: String) {
        coroutineScope.launch(Dispatchers.IO) {
            foundCar.postValue(carDao.findCarById(clrID))
        }
    }
}