package com.srhdp.project1mvvm.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.srhdp.project1mvvm.R
import com.srhdp.project1mvvm.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_movie)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}