package com.example.pruebarest.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.pruebarest.retrofit.WeatherService
import com.google.gson.JsonObject
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(val weatherService: WeatherService) {

    private var weather = MutableLiveData<Weather>()

    fun getWeather(): MutableLiveData<Weather> {
        return weather
    }

    fun callWeatherServiceApi() {
        val cityName = "London"
        val resp = weatherService.getWeather()

        resp.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: retrofit2.Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(
                call: retrofit2.Call<JsonObject>,
                response: Response<JsonObject>
            ) {
                val weatherObject = response.body()?.asJsonObject
                val temp: Float = weatherObject?.getAsJsonObject("main")?.get("temp")?.asFloat ?: 0F
                val description =
                    weatherObject?.getAsJsonArray("weather")?.get(0)
                        ?.asJsonObject?.get("description")?.asString ?: ""
                weather.value = Weather(cityName, temp, description)
            }
        })
    }

}