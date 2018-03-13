package com.androiddesdecero.retrofit.futbol

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by albertopalomarrobledo on 12/3/18.
 */
interface ApiFutbol {

    @GET("v1/fixtures")
    abstract fun getResultados(): Call<Resultados>
}