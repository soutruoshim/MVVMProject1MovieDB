package com.srhdp.project1mvvm.data.repository.aritist

import android.util.Log
import com.srhdp.project1mvvm.data.domain.repository.ArtistRepository
import com.srhdp.project1mvvm.data.model.artist.Artist
import com.srhdp.project1mvvm.data.model.artist.ArtistList
import com.srhdp.project1mvvm.data.repository.aritist.datasource.ArtistCacheDataSource
import com.srhdp.project1mvvm.data.repository.aritist.datasource.ArtistLocalDataSource
import com.srhdp.project1mvvm.data.repository.aritist.datasource.ArtistRemoteDataSource


class ArtistRepositoryImpl(private val artistRemoteDataSource: ArtistRemoteDataSource,
                           private val artistLocalDataSource: ArtistLocalDataSource,
                           private val artistCacheDataSource: ArtistCacheDataSource
):ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var  artistList: List<Artist>
        try{
            val response = artistRemoteDataSource.getArtists()
            val body: ArtistList? = response.body()
            if(body!= null){
                artistList = body.artists
            }
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var  artistList: List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        if(artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var  artistList: List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (ex:Exception){
            Log.i("MyTag", ex.toString())
        }
        if(artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}