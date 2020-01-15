package com.example.pruebarest

import android.app.Application
import com.example.pruebarest.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class RestApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .applicationBind(this)
            .build()
            .inject(this)
    }

    override fun androidInjector() = dispatchingAndroidInjector

}