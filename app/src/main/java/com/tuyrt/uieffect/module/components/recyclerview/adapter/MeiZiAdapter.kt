package com.tuyrt.uieffect.module.components.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.data.model.MeiZi

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class MeiZiAdapter(private val context: Context) :
    ListAdapter<MeiZi, MeiZiAdapter.ViewHolder>(object : DiffUtil.ItemCallback<MeiZi>() {

        override fun areItemsTheSame(oldItem: MeiZi, newItem: MeiZi): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MeiZi, newItem: MeiZi): Boolean {
            return oldItem == newItem
        }
    }) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPic: ImageView = view.findViewById(R.id.ivPic)
    }

    private val mMeiZiList = ArrayList<MeiZi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_meizhi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meiZi = getItem(position)

        Glide.with(context)
            .asDrawable()
            .load(meiZi.url)
            .into(holder.ivPic)
    }


    //累加 添加
    fun addAll(list: List<MeiZi>) {
        mMeiZiList.addAll(list)

        val newList = ArrayList<MeiZi>()
        newList.addAll(mMeiZiList)

        submitList(newList)
    }

    // 刷新
    fun clearAddAll(list: List<MeiZi>) {
        mMeiZiList.clear()
        addAll(list)
    }
}