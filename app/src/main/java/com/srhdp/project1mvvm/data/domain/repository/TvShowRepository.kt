package com.srhdp.project1mvvm.data.domain.repository

import com.srhdp.project1mvvm.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}