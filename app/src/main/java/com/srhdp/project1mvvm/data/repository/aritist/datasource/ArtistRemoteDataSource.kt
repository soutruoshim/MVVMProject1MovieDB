package com.srhdp.project1mvvm.data.repository.aritist.datasource

import com.srhdp.project1mvvm.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}