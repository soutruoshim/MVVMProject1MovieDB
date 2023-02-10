package com.srhdp.project1mvvm.presentation.di

import com.srhdp.project1mvvm.data.api.TMDBService
import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.srhdp.project1mvvm.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.srhdp.project1mvvm.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.srhdp.project1mvvm.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

}