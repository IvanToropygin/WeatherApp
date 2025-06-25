package com.example.weatherapp.data.repository

import com.example.weatherapp.data.local.db.FavouritesCityDao
import com.example.weatherapp.data.mapper.toDbModel
import com.example.weatherapp.data.mapper.toEntities
import com.example.weatherapp.domain.entity.City
import com.example.weatherapp.domain.repository.FavouriteRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouriteRepositoryImpl @Inject constructor(
    private val favouritesCityDao: FavouritesCityDao
) : FavouriteRepository {

    override val favouriteCities: Flow<List<City>> = favouritesCityDao.getFavouriteCities()
        .map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> = favouritesCityDao
        .observeIsFavourite(cityId)

    override suspend fun addToFavourite(city: City) = favouritesCityDao
        .addToFavourite(city.toDbModel())

    override suspend fun removeFromFavourite(cityId: Int) = favouritesCityDao
        .removeFromFavourite(cityId)
}