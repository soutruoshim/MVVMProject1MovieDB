package com.srhdp.project1mvvm.data.repository.movie.datasourceimpl

import com.srhdp.project1mvvm.data.api.TMDBService
import com.srhdp.project1mvvm.data.model.movie.MovieList
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}