package com.srhdp.project1mvvm.data.repository.aritist.datasourceimpl

import com.srhdp.project1mvvm.data.model.artist.Artist
import com.srhdp.project1mvvm.data.repository.aritist.datasource.ArtistCacheDataSource

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