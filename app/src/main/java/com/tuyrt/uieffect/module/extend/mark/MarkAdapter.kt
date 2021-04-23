package com.tuyrt.uieffect.module.extend.mark

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class MarkAdapter(val context: Context) : RecyclerView.Adapter<MarkAdapter.MarkHolder>() {

    private var score = 0

    override fun onBindViewHolder(holder: MarkHolder, position: Int) {
        when (score) {
            10 -> showHappy(holder, position)
            9 -> showSmile(holder, position)
            in 4..8 -> showWorried(holder, position)
            0 -> showEmpty(holder, position)
            else -> showCrying(holder, position)
        }

        holder.itemView.setOnClickListener {
            score = position + 1
            notifyDataSetChanged()
        }

    }

    private fun showEmpty(holder: MarkHolder, position: Int) {
        holder.tvScore.text = "${position + 1} 分"

        if (position == 9)
            holder.ivPic.setImageResource(R.drawable.icon_happy_3)
        else if (position == 8)
            holder.ivPic.setImageResource(R.drawable.icon_smail_2)
        else if (position > 2) {
            holder.ivPic.setImageResource(R.drawable.icon_worried_2)
        } else {
            holder.ivPic.setImageResource(R.drawable.icon_angry_2)
        }
    }

    private fun showCrying(holder: MarkHolder, position: Int) {
        if (position == 9) {
            holder.tvScore.text = "10分"
            holder.ivPic.setImageResource(R.drawable.icon_happy_2)
        } else if (position == score - 1) {
            holder.tvScore.text = "${position + 1} 分满意"
            holder.ivPic.setImageResource(R.drawable.icon_crying_1)
        } else if (position < score - 1) {
            holder.tvScore.text = "${position + 1}  分"
            holder.ivPic.setImageResource(R.drawable.icon_angry_1)
        } else {
            holder.tvScore.text = "${position + 1}  分"
            holder.ivPic.setImageResource(R.drawable.icon_sad_2)
        }

    }

    private fun showWorried(holder: MarkHolder, position: Int) {

        if (position == 9) {
            holder.tvScore.text = "10分"
            holder.ivPic.setImageResource(R.drawable.icon_happy_2)
        } else if (position == 8 || position > score - 1) {
            holder.tvScore.text = "${position + 1}  分"
            holder.ivPic.setImageResource(R.drawable.icon_friendly_2)
        } else if (position == score - 1) {
            holder.tvScore.text = "${position + 1}  分满意"
            holder.ivPic.setImageResource(R.drawable.icon_worried_1)
        } else {
            holder.tvScore.text = "${position + 1}  分"
            holder.ivPic.setImageResource(R.drawable.icon_sad_1)
        }
    }

    private fun showSmile(holder: MarkHolder, position: Int) {
        if (position == 9) {
            holder.tvScore.text = "10分"
            holder.ivPic.setImageResource(R.drawable.icon_happy_2)
        } else if (position == 8) {
            holder.tvScore.text = "9分满意"
            holder.ivPic.setImageResource(R.drawable.icon_smail_1)
        } else {
            holder.tvScore.text = "${position + 1} 分"
            holder.ivPic.setImageResource(R.drawable.icon_friendly_1)
        }
    }

    private fun showHappy(holder: MarkHolder, position: Int) {
        if (position == 9) {
            holder.tvScore.text = "10分满意"
            holder.ivPic.setImageResource(R.drawable.icon_happy_1)
        } else {
            holder.tvScore.text = "${position + 1} 分"
            holder.ivPic.setImageResource(R.drawable.icon_friendly_1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarkHolder {

        return MarkHolder(LayoutInflater.from(context).inflate(R.layout.item_mark, parent, false))
    }

    override fun getItemCount() = 10


    class MarkHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val ivPic = itemview.findViewById<ImageView>(R.id.ivPic)
        val tvScore = itemview.findViewById<TextView>(R.id.tvScore)

    }
}