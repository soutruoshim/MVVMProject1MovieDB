package com.srhdp.project1mvvm.data.repository.tvshow.datasourceimpl

import com.srhdp.project1mvvm.data.db.TvShowDao
import com.srhdp.project1mvvm.data.model.tvshow.TvShow
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvshowDao: TvShowDao): TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> = tvshowDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvshows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.saveTvShow(tvshows)
        }
    }
    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.deleteAllTvShows()
        }
    }
}