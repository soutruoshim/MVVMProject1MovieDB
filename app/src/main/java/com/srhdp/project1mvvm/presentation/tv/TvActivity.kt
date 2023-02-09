package com.srhdp.project1mvvm.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.srhdp.project1mvvm.R
import com.srhdp.project1mvvm.databinding.ActivityTvBinding

class TvActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTvBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_tv)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv)
    }
}