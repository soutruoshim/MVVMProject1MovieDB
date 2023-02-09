package com.srhdp.project1mvvm.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.srhdp.project1mvvm.R
import com.srhdp.project1mvvm.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding:ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_artist)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}