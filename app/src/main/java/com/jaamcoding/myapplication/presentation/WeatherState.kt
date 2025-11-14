package com.jaamcoding.myapplication.presentation

import com.jaamcoding.myapplication.data.remote.weather.WeatherResponse
import com.jaamcoding.myapplication.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)