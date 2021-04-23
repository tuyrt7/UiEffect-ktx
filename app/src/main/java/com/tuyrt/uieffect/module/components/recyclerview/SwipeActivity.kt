package com.tuyrt.uieffect.module.components.recyclerview

import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs.recyclerview.ui.decoration.DividerDecoration
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.module.components.recyclerview.adapter.SwipeAdapter
import com.tuyrt.uieffect.module.components.recyclerview.touch.SwipeCallBack
import com.tuyrt.uieffect.databinding.ActivityRecyclerSwipeBinding

/**
 * Created by tuyrt7 on 2021/4/21.
 */
class SwipeActivity : BaseActivity<NoViewModel, ActivityRecyclerSwipeBinding>() {

    private val list = ArrayList<String>()

    private val mAdapter by lazy {
        SwipeAdapter(this, list)
    }

    override val layoutId: Int
        get() = R.layout.activity_recycler_swipe

    override fun initView(savedInstanceState: Bundle?) {
        for (i in 0 until 100) {
            list.add("item $i")
        }

        binding.rvList.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@SwipeActivity, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerDecoration(this@SwipeActivity, LinearLayoutManager.VERTICAL))

            // 拖拽 item
            val itemTouchHelper = ItemTouchHelper(SwipeCallBack(mAdapter))
            itemTouchHelper.attachToRecyclerView(this)
        }
    }
}