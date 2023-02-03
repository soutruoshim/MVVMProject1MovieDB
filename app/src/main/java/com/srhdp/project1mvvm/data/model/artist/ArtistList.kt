package com.srhdp.project1mvvm.data.model.artist


import com.google.gson.annotations.SerializedName
import com.srhdp.project1mvvm.data.model.artist.Artist

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)