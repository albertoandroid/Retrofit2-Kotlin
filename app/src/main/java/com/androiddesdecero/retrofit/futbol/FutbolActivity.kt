package com.androiddesdecero.retrofit.futbol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.androiddesdecero.retrofit.R
import kotlinx.android.synthetic.main.activity_futbol.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.transform.Templates

class FutbolActivity : AppCompatActivity() {

    val URLAPI = "https://www.football-data.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futbol)

        futbolActivityRv.layoutManager = LinearLayoutManager(this)
        futbolActivityRv.adapter = null

        var retrofitFutbol = Retrofit.Builder()
                .baseUrl(URLAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var apiFutbol = retrofitFutbol.create(ApiFutbol::class.java)

        var callFutbol = apiFutbol.getResultados()

        callFutbol.enqueue(object : Callback<Resultados> {
            override fun onResponse(call: Call<Resultados>, response: Response<Resultados>) {
                for(res in response.body().fixtures){
                    Log.d("Respuesta: ", res.homeTeamName + " Vs " + res.awayTeamName)
                }
                futbolActivityRv.adapter = FutbolAdapter(response.body().fixtures)
            }

            override fun onFailure(call: Call<Resultados>, t: Throwable) {
                Log.e("TAG Fallo: ", t.toString())
            }

        })
    }
}
