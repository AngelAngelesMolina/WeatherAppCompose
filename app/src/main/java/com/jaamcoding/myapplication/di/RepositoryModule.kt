package com.jaamcoding.myapplication.di

import com.jaamcoding.myapplication.data.repository.WeatherRepositoryImpl
import com.jaamcoding.myapplication.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}