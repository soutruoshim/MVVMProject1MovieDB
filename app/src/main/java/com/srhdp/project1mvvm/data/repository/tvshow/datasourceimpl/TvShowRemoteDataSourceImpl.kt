package com.srhdp.project1mvvm.data.repository.tvshow.datasourceimpl

import com.srhdp.project1mvvm.data.api.TMDBService
import com.srhdp.project1mvvm.data.model.tvshow.TvShowList
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    TvShowRemoteDataSource {
    override suspend fun geTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}