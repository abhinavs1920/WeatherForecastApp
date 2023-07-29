package com.example.intern_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    private lateinit var cityEditText: EditText
    private lateinit var fetchWeatherButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        cityEditText = findViewById(R.id.editTextCity)
        fetchWeatherButton = findViewById(R.id.btnFetchWeather)

        fetchWeatherButton.setOnClickListener {
            val city = cityEditText.text.toString().trim()
            if (city.isNotEmpty()) {
                val intent = Intent(this, WeatherForecastActivity::class.java)
                intent.putExtra("city", city)
                startActivity(intent)
            }
        }
    }
}
