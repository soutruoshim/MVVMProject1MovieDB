package com.srhdp.project1mvvm.data.repository.aritist.datasourceimpl

import com.srhdp.project1mvvm.data.api.TMDBService
import com.srhdp.project1mvvm.data.model.artist.ArtistList
import com.srhdp.project1mvvm.data.repository.aritist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}