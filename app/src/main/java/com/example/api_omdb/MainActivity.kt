package com.example.api_omdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api_omdb.databinding.ActivityMainBinding
import com.example.api_omdb.fragment.DataFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCari.setOnClickListener{
            showFragment()
        }
    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = DataFragment()

        val textCari = binding.etCari.text
        val mBundle = Bundle()
        mBundle.putString("mCari", textCari.toString())
        mFragment.arguments = mBundle

        mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
    }
}