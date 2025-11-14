package com.jaamcoding.myapplication.data.repository

import com.jaamcoding.myapplication.data.mappers.toWeatherInfo
import com.jaamcoding.myapplication.data.remote.WeatherApi
import com.jaamcoding.myapplication.data.remote.weather.WeatherResponse
import com.jaamcoding.myapplication.domain.repository.WeatherRepository
import com.jaamcoding.myapplication.domain.util.Resource
import com.jaamcoding.myapplication.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(
        lat: Double?,
        long: Double?,
        query: String
    ): Resource<WeatherResponse> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long,
                    query = "London",
                    units = "metric"
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}