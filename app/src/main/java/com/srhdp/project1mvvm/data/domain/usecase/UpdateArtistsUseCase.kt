package com.srhdp.project1mvvm.data.domain.usecase
import com.srhdp.project1mvvm.data.domain.repository.ArtistRepository
import com.srhdp.project1mvvm.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}