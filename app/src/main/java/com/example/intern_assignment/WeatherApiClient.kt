package com.example.intern_assignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val API_KEY = "968ce0e29c9dddd428a9f6887854554e"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherApiService: WeatherApiService = retrofit.create(WeatherApiService::class.java)

    fun getApiKey(): String {
        return API_KEY
    }
}
