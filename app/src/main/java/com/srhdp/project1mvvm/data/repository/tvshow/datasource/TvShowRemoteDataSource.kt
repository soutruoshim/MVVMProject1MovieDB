package com.srhdp.project1mvvm.data.repository.tvshow.datasource

import com.srhdp.project1mvvm.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun geTvShows(): Response<TvShowList>
}