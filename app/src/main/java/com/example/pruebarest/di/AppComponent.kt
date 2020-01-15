package com.example.pruebarest.di

import android.app.Application
import com.example.pruebarest.RestApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        RestModule::class,
        MainActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(todoApp: RestApp)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder

    }
}