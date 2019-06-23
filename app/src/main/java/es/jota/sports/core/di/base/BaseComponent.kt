package es.jota.sports.core.di.base

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import dagger.Component
import es.jota.sports.data.core.platform.NetworkHandler
import es.jota.sports.core.di.network.NetworkModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [(BaseModule::class), (NetworkModule::class)])
interface BaseComponent {

    fun application(): Application

    fun context(): Context

    fun gson(): Gson

    fun networkHandler(): NetworkHandler

    fun retrofit(): Retrofit
}
