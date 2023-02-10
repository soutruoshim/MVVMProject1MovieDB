package com.srhdp.project1mvvm.data.repository.artist.datasource

import com.srhdp.project1mvvm.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}