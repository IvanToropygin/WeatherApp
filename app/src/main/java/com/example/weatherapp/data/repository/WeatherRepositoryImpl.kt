package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mapper.toEntity
import com.example.weatherapp.data.network.api.ApiService
import com.example.weatherapp.domain.entity.Forecast
import com.example.weatherapp.domain.entity.Weather
import com.example.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun getWeather(cityId: Int): Weather =
        apiService.loadCurrentWeather(query = "$PREFIX_CITY_ID$cityId").toEntity()

    override suspend fun getForecast(cityId: Int): Forecast =
        apiService.loadForecastWeather(query = "$PREFIX_CITY_ID$cityId").toEntity()

    companion object {

        private const val PREFIX_CITY_ID = "id:"
    }
}