package com.srhdp.project1mvvm.data.repository.movie.datasource

import com.srhdp.project1mvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}