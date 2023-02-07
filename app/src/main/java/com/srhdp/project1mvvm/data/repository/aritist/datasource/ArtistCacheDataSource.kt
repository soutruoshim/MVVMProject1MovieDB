package com.srhdp.project1mvvm.data.repository.aritist.datasource

import com.srhdp.project1mvvm.data.model.artist.Artist


interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistToCache(movies:List<Artist>)
}