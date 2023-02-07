package com.srhdp.project1mvvm.data.repository.tvshow

import android.util.Log
import com.srhdp.project1mvvm.data.domain.repository.TvShowRepository
import com.srhdp.project1mvvm.data.model.tvshow.TvShow
import com.srhdp.project1mvvm.data.model.tvshow.TvShowList
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.srhdp.project1mvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource

class TvShowRepositoryImpl(private val tvShowRemoteDataSource: TvShowRemoteDataSource,
                           private val tvShowLocalDataSource: TvShowLocalDataSource,
                           private val tvShowCacheDataSource: TvShowCacheDataSource
):TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var  tvShowList: List<TvShow>
        try{
            val response = tvShowRemoteDataSource.geTvShows()
            val body:TvShowList? = response.body()
            if(body!= null){
                tvShowList = body.tvShows
            }
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var  tvShowList: List<TvShow>
        try{
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var  tvShowList: List<TvShow>
        try{
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}