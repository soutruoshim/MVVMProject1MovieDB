package com.srhdp.project1mvvm.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.project1mvvm.data.domain.usecase.GetMoviesUseCase
import com.srhdp.project1mvvm.data.domain.usecase.UpdateMoviesUsecase
import com.srhdp.project1mvvm.data.model.movie.Movie

class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase, private val updateMoviesUseCase: UpdateMoviesUsecase):ViewModel() {
    fun getMovies() = liveData{
        val movieList:List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData{
        val movieList:List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }
}