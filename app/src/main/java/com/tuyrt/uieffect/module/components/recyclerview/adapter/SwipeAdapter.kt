package com.tuyrt.uieffect.module.components.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class SwipeAdapter(private val context: Context, private val mList: ArrayList<String>) : RecyclerView.Adapter<SwipeAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvText:TextView = view.findViewById(R.id.tvText)
    }

    override fun getItemCount(): Int  = mList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_swipe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvText.text = mList[position]
    }

    fun delete(position: Int) {
        if (position < 0 || position > mList.size)
            return

        mList.removeAt(position)
        notifyItemRemoved(position)
    }

}