package com.srhdp.project1mvvm.data.domain.usecase

import com.srhdp.project1mvvm.data.domain.repository.TvShowRepository
import com.srhdp.project1mvvm.data.model.tvshow.TvShow

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}