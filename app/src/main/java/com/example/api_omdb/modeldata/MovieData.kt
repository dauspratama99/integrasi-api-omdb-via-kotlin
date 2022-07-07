package com.example.api_omdb.modeldata

import com.google.gson.annotations.SerializedName

data class MovieData (
        val Year:String, val Title:String,
        @SerializedName("Poster") val gambar:String


        )
