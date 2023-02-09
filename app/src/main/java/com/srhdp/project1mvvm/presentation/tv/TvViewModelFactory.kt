package com.srhdp.project1mvvm.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srhdp.project1mvvm.data.domain.usecase.GetTvShowsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.UpdateTvShowsUseCase


class TvViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
    }
}

