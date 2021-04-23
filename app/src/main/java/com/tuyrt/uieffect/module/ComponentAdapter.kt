package com.tuyrt.uieffect.module

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.data.model.ComponentItem

/**
 * Created by tuyrt7 on 2021/4/21.
 */
class ComponentAdapter(var componentItems: List<ComponentItem>) :
    RecyclerView.Adapter<ComponentAdapter.ViewHolder>() {
    private var itemClick: ((ComponentItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_component, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTv.text = componentItems[position].title
        holder.itemView.setOnClickListener {
            itemClick?.invoke(componentItems[position])
        }
    }

    override fun getItemCount(): Int = componentItems.size

    fun setItemClick(itemClick: (ComponentItem) -> Unit) {
        this.itemClick = itemClick
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTv: TextView = view.findViewById(R.id.component_title_tv)
    }
}