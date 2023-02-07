package com.srhdp.project1mvvm.data.repository.movie.datasourceimpl

import com.srhdp.project1mvvm.data.model.movie.Movie
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}