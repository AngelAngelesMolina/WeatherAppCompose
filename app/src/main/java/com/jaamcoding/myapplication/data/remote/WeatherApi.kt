package com.jaamcoding.myapplication.data.remote

import com.jaamcoding.myapplication.data.remote.weather.WeatherResponse
import com.jaamcoding.myapplication.domain.common.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    //    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    @GET("weather")
    suspend fun getWeatherData(
        @Query("q") query: String,
        @Query("appid") apiKey: String = ApiConstants.APIKEY,
        @Query("units") units: String?,
        @Query("latitude") lat: Double? = null,
        @Query("longitude") long: Double? = null
    ): WeatherResponse
}