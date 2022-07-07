package com.example.api_omdb

import com.example.api_omdb.modeldata.SearchData
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("?s=spider&apikey=ada3db4c")

    fun getMovie(): Call<SearchData>
}