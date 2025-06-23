package com.example.weatherapp.presentation.root

import com.arkivanov.decompose.ComponentContext

class DefaultComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext