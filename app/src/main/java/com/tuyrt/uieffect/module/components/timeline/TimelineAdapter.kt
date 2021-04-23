package com.tuyrt.uieffect.module.components.timeline

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R
import java.util.ArrayList

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class TimelineAdapter(private var mContext: Context, var data: ArrayList<String>, var time: ArrayList<String>) : RecyclerView.Adapter<TimelineAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) {
            holder.textView.setTextColor(Color.parseColor("#4BAB6E"))
            holder.tvTime.setTextColor(Color.parseColor("#4BAB6E"))
        } else {
            holder.textView.setTextColor(Color.parseColor("#9B9B9B"))
            holder.tvTime.setTextColor(Color.parseColor("#9B9B9B"))
        }

        holder.tvTime.setTextColor(Color.parseColor("#9B9B9B"))

        holder.textView.text = data[position]
        holder.tvTime.text = time[position]
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.item_timeline, parent, false)
        return ViewHolder(itemView)
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var textView: TextView = item.findViewById(R.id.textView_item)
        var tvTime: TextView = item.findViewById(R.id.tvTime_item)

    }

}