package com.example.besinlerkitabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.besinlerkitabi.R
import com.example.besinlerkitabi.model.Besin
import com.example.besinlerkitabi.utils.gorselIndir
import com.example.besinlerkitabi.utils.placeHolderYap
import com.example.besinlerkitabi.view.BesinDetayiFragment
import com.example.besinlerkitabi.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.besin_recycler_row.view.*

class BesinRecyclerAdapter(val besinList: ArrayList<Besin>) : RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {
    class BesinViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.isim.text = besinList.get(position).besinIsim
        holder.itemView.kalori.text = besinList.get(position).besinKalori
        //görsel kısmı eklenecek glide
        holder.itemView.setOnClickListener {
            val action = BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayiFragment(besinList.get(position).uuid)
            Navigation.findNavController(it).navigate(action)
        }
        holder.itemView.imageView.gorselIndir(besinList.get(position).besinGorsel, placeHolderYap(holder.itemView.context))

    }

    override fun getItemCount(): Int {
        return besinList.size
    }

    fun besinListesiniGuncelle(yeniBesinListesi : List<Besin>){
        besinList.clear()
        besinList.addAll(yeniBesinListesi)
        notifyDataSetChanged()

    }
}