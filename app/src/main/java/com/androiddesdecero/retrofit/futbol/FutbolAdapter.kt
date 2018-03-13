package com.androiddesdecero.retrofit.futbol

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androiddesdecero.retrofit.R
import kotlinx.android.synthetic.main.list_item_resultados.view.*
import java.io.File
import javax.xml.transform.Templates

/**
 * Created by albertopalomarrobledo on 12/3/18.
 */
class FutbolAdapter (val resultados: ArrayList<Partido>): RecyclerView.Adapter<FutbolAdapter.FutbolViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutbolViewHolder {
        var layoutInflate = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_resultados, parent, false)

        return FutbolViewHolder(layoutInflate)
    }

    override fun onBindViewHolder(holder: FutbolViewHolder, position: Int) {
         var itemPartido = resultados[position]
         holder.bindPartido(itemPartido)
    }

    override fun getItemCount(): Int {
        return resultados.size
    }


    class FutbolViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindPartido(partido: Partido){
            itemView.lirTvAway.text = partido.awayTeamName
            itemView.lirTvHome.text = partido.homeTeamName
        }
    }
}