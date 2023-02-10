package com.srhdp.project1mvvm.data.repository.artist.datasourceImpl

import com.srhdp.project1mvvm.data.model.artist.Artist
import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}