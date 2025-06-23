package com.example.weatherapp.presentation.favourites

import com.arkivanov.decompose.ComponentContext

class DefaultFavouriteComponent(
    componentContext: ComponentContext
) : FavouriteComponent, ComponentContext by componentContext