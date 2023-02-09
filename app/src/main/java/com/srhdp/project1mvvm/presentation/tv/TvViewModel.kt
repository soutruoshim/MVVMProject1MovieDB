package com.srhdp.project1mvvm.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.project1mvvm.data.domain.usecase.GetTvShowsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.UpdateTvShowsUseCase
import com.srhdp.project1mvvm.data.model.tvshow.TvShow

class TvViewModel(private val getTvShowsUseCase: GetTvShowsUseCase, private val updateTvShowsUseCase: UpdateTvShowsUseCase):ViewModel() {
    fun getTvShows() = liveData{
        val tvShowList:List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateMovies() = liveData{
        val tvShowList:List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}