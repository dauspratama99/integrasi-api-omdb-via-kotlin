package com.example.api_omdb.modeldata

import com.google.gson.annotations.SerializedName

data class SearchData(
    @SerializedName("Search") val data:List<MovieData>,
    @SerializedName("Response") val res:String,
    @SerializedName("totalResults") val totalData:Int
)
