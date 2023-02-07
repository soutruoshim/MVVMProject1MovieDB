package com.srhdp.project1mvvm.data.repository.movie.datasource

import com.srhdp.project1mvvm.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMovieToCache(movies:List<Movie>)
}