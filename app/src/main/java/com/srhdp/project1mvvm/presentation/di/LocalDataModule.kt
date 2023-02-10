package com.srhdp.project1mvvm.presentation.di

import com.srhdp.project1mvvm.data.db.ArtistDao
import com.srhdp.project1mvvm.data.db.MovieDao
import com.srhdp.project1mvvm.data.db.TvShowDao
import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.srhdp.project1mvvm.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.srhdp.project1mvvm.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.srhdp.project1mvvm.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }
}