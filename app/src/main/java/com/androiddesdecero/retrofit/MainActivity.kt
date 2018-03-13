package com.androiddesdecero.retrofit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androiddesdecero.retrofit.futbol.FutbolActivity
import com.androiddesdecero.retrofit.tiempo.TiempoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityBtApiTiempo.setOnClickListener({
            var intent = Intent(this, TiempoActivity::class.java)
            startActivity(intent)
        })

        mainActivityBtApiFutbol.setOnClickListener({
            var intent = Intent(this, FutbolActivity::class.java)
            startActivity(intent)
        })



        /*

        JSON Objetos -> {}
        {"nombre" : "Alberto"
         "trabajo": "Programador Android"}

        JSON Array -> []
        ["kotlin", "Java", "php"]


        {
        "nombre": "Alberto",
        "trabajo": "Programador Android",
        "lenguajes": ["kotlin", "java", "php"]
        }

        Array []
            "list"
                "dt"
                "main"
                    "temp"
                    "humidity"


                    Array "fixtures"
                    Objeto "homeTeamName" ""awayTeanName"
         */






    }
}
