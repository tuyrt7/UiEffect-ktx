package com.tuyrt.uieffect.module.components.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R

/**
 * Created by tuyrt7 on 2021/3/22.
 */
class ParallaxAdapter : RecyclerView.Adapter<ParallaxAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemViewTv: TextView = itemView.findViewById(R.id.item_text)

        fun bind(data: String) {
            itemViewTv.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder =
        MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_parallax, parent, false)
        )

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind("Item-$position")
    }

    override fun getItemCount(): Int = 100
}