package es.jota.sports.data.source.remote

import es.jota.sports.data.entity.SportEntity
import retrofit2.Call
import retrofit2.Retrofit

class SportsRemote(retrofit: Retrofit) : SportsAPI {

    private val sportsAPI by lazy { retrofit.create(SportsAPI::class.java) }

    override fun getSports(): Call<List<SportEntity>> = sportsAPI.getSports()
}