package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers(
        "x-rapidapi-host: deezerdevs-deezer.p.rapidapi.com",
        "x-rapidapi-key: 3e29fe1cfbmsh5d399647dcf40aap198658jsn4b61abae07c3"
    )
@GET("search")
fun getData(@Query("q") query : String) : Call<MyData>

}