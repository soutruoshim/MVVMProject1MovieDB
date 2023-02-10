package com.srhdp.project1mvvm.data.repository.movie

import android.util.Log
import com.srhdp.project1mvvm.data.domain.repository.MovieRepository
import com.srhdp.project1mvvm.data.model.movie.Movie
import com.srhdp.project1mvvm.data.model.movie.MovieList
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.srhdp.project1mvvm.data.repository.movie.datasource.MovieRemoteDatasource

class MovieRepositoryImpl(private val movieRemoteDataSource: MovieRemoteDatasource,
                          private val movieLocalDataSource: MovieLocalDataSource,
                          private val movieCacheDataSource: MovieCacheDataSource
):MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var  movieList: List<Movie>
        try{
            val response = movieRemoteDataSource.getMovies()
            val body:MovieList? = response.body()
            if(body!= null){
                movieList = body.movies
            }
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var  movieList: List<Movie>
        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var  movieList: List<Movie>
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }
        return movieList
    }
}