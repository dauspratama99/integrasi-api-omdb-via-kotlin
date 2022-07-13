package com.example.api_omdb

import com.example.api_omdb.modeldata.MovieDetailData
import com.example.api_omdb.modeldata.SearchData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
//    @GET("?s=spider&apikey=ada3db4c")
        @GET("/")
        fun getMovie(
                @Query("s") s:String?,
                @Query("apiKey") apiKey:String
        ): Call<SearchData>

        @GET("/")
        fun getDetailMovie(
                @Query("i") i:String?,
                @Query("apiKey") apiKey:String,
        ): Call<MovieDetailData>
}