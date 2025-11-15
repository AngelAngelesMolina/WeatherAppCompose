package com.jaamcoding.myapplication.presentation

import com.jaamcoding.myapplication.domain.weather.WeatherData

data class WeatherState(
    val weatherInfo: WeatherData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)