package com.example.api_omdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.api_omdb.databinding.ActivityDetailBinding
import com.example.api_omdb.modeldata.MovieDetailData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    var b:Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        b = intent.extras
        val i = b?.getString("imdbid")
        val apikey = "ada3db4c"

        RClient.instances.getDetailMovie(i,apikey).enqueue(object:Callback<MovieDetailData>{
            override fun onResponse(
                call: Call<MovieDetailData>,
                response: Response<MovieDetailData>
            ) {
                binding.tvTahun.text =  response.body()?.Year
                binding.tvJudulmovie.text =  response.body()?.Title
                binding.tvTglrilis.text =  response.body()?.rilis
                binding.tvKeterangan.text =  response.body()?.keterangan

                Glide.with(this@DetailActivity).load(response.body()?.gambar).into(binding.imgGambarposter)
            }

            override fun onFailure(call: Call<MovieDetailData>, t: Throwable) {

            }

        })

    }
}