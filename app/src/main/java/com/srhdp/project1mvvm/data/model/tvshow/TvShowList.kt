package com.srhdp.project1mvvm.data.model.tvshow


import com.google.gson.annotations.SerializedName
import com.srhdp.project1mvvm.data.model.tvshow.TvShow

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>
)