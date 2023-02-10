package com.srhdp.project1mvvm.presentation.di


import com.srhdp.project1mvvm.data.repository.artist.ArtistRepositoryImpl
import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistCacheDataSource
import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.srhdp.project1mvvm.data.repository.artist.datasource.ArtistRemoteDatasource
import com.srhdp.project1mvvm.data.repository.movie.MovieRepositoryImpl
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieRemoteDatasource
import com.srhdp.project1mvvm.data.repository.tvshow.TvShowRepositoryImpl
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.srhdp.project1mvvm.data.domain.repository.ArtistRepository
import com.srhdp.project1mvvm.data.domain.repository.MovieRepository
import com.srhdp.project1mvvm.data.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

}