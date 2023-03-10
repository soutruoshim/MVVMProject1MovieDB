package com.srhdp.project1mvvm.data.repository.artist.datasource

import com.srhdp.project1mvvm.data.model.artist.Artist


interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(movies:List<Artist>)
    suspend fun clearAll()
}