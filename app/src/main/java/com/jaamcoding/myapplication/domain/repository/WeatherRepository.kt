package com.jaamcoding.myapplication.domain.repository

import com.jaamcoding.myapplication.data.remote.weather.WeatherResponse
import com.jaamcoding.myapplication.domain.util.Resource
import com.jaamcoding.myapplication.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double?, long: Double?, query:String): Resource<WeatherResponse>
}