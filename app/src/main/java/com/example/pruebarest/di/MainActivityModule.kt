package com.example.pruebarest.di

import com.example.pruebarest.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module( includes = [] )
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

}