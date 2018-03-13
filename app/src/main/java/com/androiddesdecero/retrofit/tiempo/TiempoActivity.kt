package com.androiddesdecero.retrofit.tiempo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.androiddesdecero.retrofit.R
import kotlinx.android.synthetic.main.activity_tiempo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.transform.Templates

class TiempoActivity : AppCompatActivity() {

    val URLAPI = "http://samples.openweathermap.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo)

        tiempoActivityRv.layoutManager = LinearLayoutManager(this)
        tiempoActivityRv.adapter = null

        var retrofitTiempo = Retrofit.Builder()
                .baseUrl(URLAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var apiTiempo = retrofitTiempo.create(ApiTiempo::class.java)
        var callTiempo = apiTiempo.getTiempo()
        callTiempo.enqueue(object : Callback<Metereologia> {
            override fun onFailure(call: Call<Metereologia>, t: Throwable?) {
                Log.e("TAG Fallo: ", t.toString())
            }

            override fun onResponse(call: Call<Metereologia>, response: Response<Metereologia>) {
                for(res in response.body().list){
                    Log.d("TAG Respuesta: ", res.main.temp)
                }
                tiempoActivityRv.adapter = TiempoAdapter(response.body().list)
            }

        })
    }
}
