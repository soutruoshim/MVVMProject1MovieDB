package com.srhdp.project1mvvm.data.model.movie


import com.google.gson.annotations.SerializedName
import com.srhdp.project1mvvm.data.model.movie.Movie

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)