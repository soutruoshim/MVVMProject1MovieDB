package com.srhdp.project1mvvm.data.repository.tvshow.datasourceimpl

import com.srhdp.project1mvvm.data.model.tvshow.TvShow
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {
    private var tvshowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvshowList
    }

    override suspend fun saveTvShowsToCache(tvshows: List<TvShow>) {
        tvshowList.clear()
        tvshowList = ArrayList(tvshows)
    }
}