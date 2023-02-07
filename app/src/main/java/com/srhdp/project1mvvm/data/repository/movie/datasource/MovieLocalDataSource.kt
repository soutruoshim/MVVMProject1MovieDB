package com.srhdp.project1mvvm.data.repository.movie.datasource

import com.srhdp.project1mvvm.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}