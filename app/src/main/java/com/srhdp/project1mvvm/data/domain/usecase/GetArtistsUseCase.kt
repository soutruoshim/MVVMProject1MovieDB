package com.srhdp.project1mvvm.data.domain.usecase

import com.srhdp.project1mvvm.data.domain.repository.ArtistRepository
import com.srhdp.project1mvvm.data.model.artist.Artist

class GetArtistsUseCase(private val artisRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artisRepository.getArtists()
}