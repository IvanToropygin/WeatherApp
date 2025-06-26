package com.example.weatherapp.presentation.favourites

import com.example.weatherapp.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface FavouriteComponent {

    val model: StateFlow<FavouriteStore.State>

    fun onClickSearch()

    fun onClickFavourite()

    fun onCityItemClick(city: City)
}