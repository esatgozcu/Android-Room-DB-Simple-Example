package com.esatgozcu.roomdbexample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.esatgozcu.roomdbexample.database.Car
import com.esatgozcu.roomdbexample.repository.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(private val carRepository: CarRepository) : ViewModel(){

    val carList: LiveData<List<Car>> = carRepository.allCars

    init {
        getAllCar()
    }
    private fun getAllCar(){
        carRepository.getAllCars()
    }
    fun addCar(car: Car){
        carRepository.addCar(car, completion = {
            getAllCar()
        })
    }
    fun updateCar(car: Car){
        carRepository.updateCarDetails(car, completion = {
            getAllCar()
        })
    }
    fun findCarById(crId: Int){
        carRepository.findCarById(crId)
    }
    fun deleteCar(car: Car){
        carRepository.deleteCar(car, completion = {
            getAllCar()
        })
    }
}