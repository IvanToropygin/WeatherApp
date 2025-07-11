package com.example.weatherapp.data.mapper


import com.example.weatherapp.data.network.dto.WeatherCurrentDto
import com.example.weatherapp.data.network.dto.WeatherDto
import com.example.weatherapp.data.network.dto.WeatherForecastDto
import com.example.weatherapp.domain.entity.Forecast
import com.example.weatherapp.domain.entity.Weather
import java.util.Calendar
import java.util.Date

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = conditionDto.text,
    conditionUrl = conditionDto.iconUrl.correctImageUrl(),
    date = date.toCalendar()
)

fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()

fun WeatherForecastDto.toEntity(): Forecast = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecastDto.forecastDay.drop(1).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto
        Weather(
            tempC = dayWeatherDto.tempC,
            conditionText = dayWeatherDto.conditionDto.text,
            conditionUrl = dayWeatherDto.conditionDto.iconUrl.correctImageUrl(),
            date = dayDto.date.toCalendar()
        )
    },
)

private fun Long.toCalendar() = Calendar.getInstance()
    .apply { time = Date(this@toCalendar * 1000) }

private fun String.correctImageUrl() = "https:$this"
    .replace(oldValue = "64x64", newValue = "128x128")