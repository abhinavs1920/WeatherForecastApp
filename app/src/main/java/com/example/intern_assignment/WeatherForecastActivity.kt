package com.example.intern_assignment

import WeatherData
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherForecastActivity : AppCompatActivity() {
    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var humidityTextView: TextView
    private lateinit var windSpeedTextView: TextView
    private lateinit var weatherConditionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_forecast)

        cityTextView = findViewById(R.id.textViewCity)
        temperatureTextView = findViewById(R.id.textViewTemperature)
        humidityTextView = findViewById(R.id.textViewHumidity)
        windSpeedTextView = findViewById(R.id.textViewWindSpeed)
        weatherConditionTextView = findViewById(R.id.textViewWeatherCondition)

        val city = intent.getStringExtra("city")
        city?.let {
            // Fetch weather data for the given city using the API here
            WeatherApiClient.weatherApiService.getWeatherData(city, WeatherApiClient.getApiKey())
                .enqueue(object : Callback<WeatherData> {
                    override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                        if (response.isSuccessful) {
                            val weatherData = response.body()
                            weatherData?.let {
                                // Update the TextViews with actual weather data from the API response
                                cityTextView.text = city
                                temperatureTextView.text = "Temperature: ${it.temperature}°C"
                                humidityTextView.text = "Humidity: ${it.humidity}%"
                                windSpeedTextView.text = "Wind Speed: ${it.windSpeed} m/s"
                                weatherConditionTextView.text = "Weather Condition: ${it.weatherCondition}"
                            }
                        } else {
                            // Handle API error here
                        }
                    }

                    override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                        // Handle network or other errors here
                    }
                })
        }
    }
}
