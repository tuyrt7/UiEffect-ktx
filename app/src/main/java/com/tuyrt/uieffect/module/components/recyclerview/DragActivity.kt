package com.tuyrt.uieffect.module.components.recyclerview

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.tuyrt.uieffect.module.components.recyclerview.decoration.GridDividerDecoration
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.module.components.recyclerview.adapter.DragAdapter
import com.tuyrt.uieffect.module.components.recyclerview.touch.DragCallBack
import com.tuyrt.uieffect.databinding.ActivityRecyclerDragBinding

/**
 * Created by tuyrt7 on 2021/4/21.
 *
 */
class DragActivity : BaseActivity<NoViewModel, ActivityRecyclerDragBinding>() {

    private val list = ArrayList<String>()

    private val mAdapter by lazy {
        DragAdapter(this, list)
    }

    override val layoutId: Int
        get() = R.layout.activity_recycler_drag

    override fun initView(savedInstanceState: Bundle?) {
        for (i in 0 until 100) {
            list.add("item $i")
        }

        binding.rvList.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(this@DragActivity,3, GridLayoutManager.VERTICAL, false)
            addItemDecoration(GridDividerDecoration(this@DragActivity))

            // 拖拽 item
            val itemTouchHelper = ItemTouchHelper(DragCallBack(mAdapter))
            itemTouchHelper.attachToRecyclerView(this)
        }
    }
}