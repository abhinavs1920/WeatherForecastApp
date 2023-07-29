package com.example.intern_assignment

// WeatherApiService.kt
import WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Call<WeatherData>
}
