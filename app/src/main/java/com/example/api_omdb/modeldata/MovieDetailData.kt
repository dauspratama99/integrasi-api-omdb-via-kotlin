package com.example.api_omdb.modeldata

import com.google.gson.annotations.SerializedName

data class MovieDetailData(
    val Year:String,
    val Title:String,
    @SerializedName("Released") val rilis:String,
    @SerializedName("Poster") val gambar:String,
    @SerializedName("Plot") val keterangan:String,
)
