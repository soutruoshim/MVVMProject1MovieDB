package com.srhdp.project1mvvm.data.repository.tvshow.datasource

import com.srhdp.project1mvvm.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvshows:List<TvShow>)
    suspend fun clearAll()
}