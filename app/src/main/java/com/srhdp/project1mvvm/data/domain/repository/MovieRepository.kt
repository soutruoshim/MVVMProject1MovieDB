package com.srhdp.project1mvvm.data.domain.repository

import com.srhdp.project1mvvm.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}