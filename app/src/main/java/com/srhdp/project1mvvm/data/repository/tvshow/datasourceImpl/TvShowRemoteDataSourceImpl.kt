package com.srhdp.project1mvvm.data.repository.tvshow.datasourceImpl

import com.srhdp.project1mvvm.data.api.TMDBService
import com.srhdp.project1mvvm.data.model.tvshow.TvShowList
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey:String):
    TvShowRemoteDatasource {
    override suspend fun geTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}