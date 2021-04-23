package com.tuyrt.uieffect.module.components.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.data.model.Province
import com.tuyrt.uieffect.view.StickyRecyclerView

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class CityAdapter(private val mContext: Context, val data: ArrayList<Province>) : StickyRecyclerView.StickyAdapter<CityAdapter.MyHolder>() {

    override fun getItemViewTitle(position: Int): String {
        return data[position].ProvinceIndex
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvProvince.text = data[position].ProvinceName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_city, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount() = data.size

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val tvProvince: TextView = item.findViewById(R.id.tvProvince)
    }

}