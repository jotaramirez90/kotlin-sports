package es.jota.sports.data.source.remote

import es.jota.sports.data.entity.SportEntity
import retrofit2.Call
import retrofit2.http.GET

interface SportsAPI {

    companion object {
        const val BASE_URL = "https://api.myjson.com"
        private const val SPORTS_PATH = "/bins/66851"
    }

    @GET(SPORTS_PATH)
    fun getSports(): Call<List<SportEntity>>
}