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
class DragAdapter(private val context: Context, private val mList: ArrayList<String>) : RecyclerView.Adapter<DragAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvText:TextView = view.findViewById(R.id.tvText)
    }

    override fun getItemCount(): Int  = mList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_drag, parent, false)
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

    fun move(oldPosition: Int, targetPosition: Int) {
        val oldString = mList.removeAt(oldPosition)
        mList.add(if (targetPosition > oldPosition) targetPosition - 1 else targetPosition, oldString)
        notifyItemMoved(oldPosition, targetPosition)
    }

}