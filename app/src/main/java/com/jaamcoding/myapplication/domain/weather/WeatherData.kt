package com.jaamcoding.myapplication.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: Int, //hora
    val name: String, //hora
    val temperatureCelsius: Double, //temp
    val pressure: Int,
    val windSpeed: Double,
    val humidity: Int,
    val weatherType: WeatherType //img
)