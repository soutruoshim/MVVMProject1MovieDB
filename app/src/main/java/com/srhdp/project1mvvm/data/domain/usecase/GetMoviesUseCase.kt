package com.srhdp.project1mvvm.data.domain.usecase

import com.srhdp.project1mvvm.data.domain.repository.MovieRepository
import com.srhdp.project1mvvm.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}