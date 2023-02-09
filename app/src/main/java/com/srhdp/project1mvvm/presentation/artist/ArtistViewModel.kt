package com.srhdp.project1mvvm.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.project1mvvm.data.domain.usecase.GetArtistsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.GetTvShowsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.UpdateArtistsUseCase
import com.srhdp.project1mvvm.data.domain.usecase.UpdateTvShowsUseCase
import com.srhdp.project1mvvm.data.model.artist.Artist
import com.srhdp.project1mvvm.data.model.tvshow.TvShow

class ArtistViewModel(private val getArtistsUseCase: GetArtistsUseCase, private val updateArtistsUseCase: UpdateArtistsUseCase):ViewModel() {
    fun getArtists() = liveData{
        val artistList:List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData{
        val artistList:List<Artist>? = updateArtistsUseCase.execute()
        emit(artistList)
    }
}