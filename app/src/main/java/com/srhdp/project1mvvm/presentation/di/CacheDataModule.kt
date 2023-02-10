package com.srhdp.project1mvvm.presentation.di

import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistCacheDataSource
import com.srhdp.project1mvvm.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.srhdp.project1mvvm.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.srhdp.project1mvvm.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}