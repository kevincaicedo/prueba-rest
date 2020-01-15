package com.example.pruebarest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebarest.model.Weather
import com.example.pruebarest.model.WeatherRepository
import javax.inject.Inject

class RestViewModel @Inject constructor(val repository: WeatherRepository): ViewModel() {

    fun getWeatherLive(): MutableLiveData<Weather> {
        return repository.getWeather()
    }

    fun callWeatherApi(){
        repository.callWeatherServiceApi()
    }

}