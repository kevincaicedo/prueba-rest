package com.example.pruebarest.retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    fun getWeather(): Call<JsonObject>

}