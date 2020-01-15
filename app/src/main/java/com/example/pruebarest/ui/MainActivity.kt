package com.example.pruebarest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.pruebarest.R
import com.example.pruebarest.databinding.ActivityMainBinding
import com.example.pruebarest.viewmodel.RestViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var restViewModel: RestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        setBindings()
    }

    private fun setBindings(){

        this.restViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(RestViewModel::class.java)
        this.restViewModel.callWeatherApi()

        val activityMainBinding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        restViewModel.getWeatherLive().observe(this, Observer {
            activityMainBinding.model = it
            println("Imprimio")
        })
        // activityMainBinding.model = restViewModel
    }
}
