package com.srhdp.project1mvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srhdp.project1mvvm.data.domain.usecase.GetArtistsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.GetTvShowsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.UpdateArtistsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.UpdateTvShowsUseCase


class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase,updateArtistsUseCase) as T
    }
}

