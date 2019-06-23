package es.jota.sports.core.di.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import es.jota.sports.data.core.platform.NetworkHandler
import es.jota.sports.data.source.remote.SportsAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideNetworkHandler(context: Context): NetworkHandler = NetworkHandler(context)

    @Provides
    @Singleton
    fun provideRetrofit(context: Context, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(SportsAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}