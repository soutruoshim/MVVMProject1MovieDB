package com.srhdp.project1mvvm.data.repository.movie.datasourceImpl

import com.srhdp.project1mvvm.data.api.TMDBService
import com.srhdp.project1mvvm.data.model.movie.MovieList
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}