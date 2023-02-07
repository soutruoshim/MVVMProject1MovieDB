package com.srhdp.project1mvvm.data.repository.tvshow.datasource

import com.srhdp.project1mvvm.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvshows:List<TvShow>)
}