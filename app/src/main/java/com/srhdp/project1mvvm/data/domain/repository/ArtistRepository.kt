package com.srhdp.project1mvvm.data.domain.repository

import com.srhdp.project1mvvm.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}