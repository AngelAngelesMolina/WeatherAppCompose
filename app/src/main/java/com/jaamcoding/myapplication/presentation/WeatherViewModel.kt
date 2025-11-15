package com.jaamcoding.myapplication.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaamcoding.myapplication.data.mappers.toWeatherInfo
import com.jaamcoding.myapplication.domain.location.LocationTracker
import com.jaamcoding.myapplication.domain.repository.WeatherRepository
import com.jaamcoding.myapplication.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

//    fun loadWeatherDefault() {
//        viewModelScope.launch {
//            state = state.copy(
//                isLoading = true,
//                error = null
//            )
//            when (val result =
//                repository.getWeatherData(lat = null, long = null, query = "Mexico city")) {
//                is Resource.Success -> {
//                    state = state.copy(
//                        weatherInfo = result.data?.toWeatherInfo(),
//                        isLoading = false,
//                        error = null
//                    )
//                }
//
//                is Resource.Error -> {
//                    state = state.copy(
//                        weatherInfo = null,
//                        isLoading = false,
//                        error = result.message
//                    )
//                }
//            }
//        }
//    }

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result = repository.getWeatherData(
                    location.latitude,
                    location.longitude,
                    query = "Mexico city"
                )) {
                    is Resource.Success -> {
                        state = state.copy(
                            weatherInfo = result.data?.toWeatherInfo(),
                            isLoading = false,
                            error = null
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }
}