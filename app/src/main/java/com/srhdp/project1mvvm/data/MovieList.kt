package com.srhdp.project1mvvm.data


import com.google.gson.annotations.SerializedName
import com.srhdp.project1mvvm.data.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)