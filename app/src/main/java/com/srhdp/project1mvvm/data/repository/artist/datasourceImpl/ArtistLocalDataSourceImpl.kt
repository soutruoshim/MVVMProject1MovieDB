package com.srhdp.project1mvvm.data.repository.artist.datasourceImpl

import com.srhdp.project1mvvm.data.db.ArtistDao
import com.srhdp.project1mvvm.data.model.artist.Artist
import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> =  artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
       CoroutineScope(Dispatchers.IO).launch {
           artistDao.saveArtist(artists)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}