package com.example.api_omdb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_omdb.MovieAdapter
import com.example.api_omdb.R
import com.example.api_omdb.RClient
import com.example.api_omdb.databinding.FragmentDataBinding
import com.example.api_omdb.modeldata.MovieData
import com.example.api_omdb.modeldata.SearchData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DataFragment : Fragment() {

    private var _binding: FragmentDataBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val list = ArrayList<MovieData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        val s = bundle?.getString("mCari")
        val apikey = "ada3db4c"

        binding.progressBar.visibility

        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)

        RClient.instances.getMovie(s, apikey).enqueue(object :Callback<SearchData>{
            override fun onResponse(call: Call<SearchData>, response: Response<SearchData>) {
                val cekResponse = response.body()?.res

                if(cekResponse == "True"){
                    val responseCode = response.code()

                    response.body()?.let { list.addAll(it.data) }
                    val adapter = MovieAdapter(list, requireContext())
                    binding.rvData.adapter = adapter
                    binding.progressBar.isVisible = false
                } else {
                    Toast.makeText(context, "Data Tidak Ditemukan", Toast.LENGTH_LONG).show()
                    binding.progressBar.isVisible = false
                }

            }

            override fun onFailure(call: Call<SearchData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}