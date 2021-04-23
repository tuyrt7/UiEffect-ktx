package com.tuyrt.uieffect.module.components.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs.recyclerview.ui.decoration.MarginDecoration
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.module.components.recyclerview.adapter.MeiZiAdapter
import com.tuyrt.uieffect.module.components.recyclerview.vm.PicturesViewModel
import com.tuyrt.uieffect.databinding.ActivityRecyclerPicturesBinding

/**
 * Created by tuyrt7 on 2021/4/21.
 * 加载大量网络图片
 */
class PicturesActivity : BaseActivity<PicturesViewModel, ActivityRecyclerPicturesBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_recycler_pictures

    private val mAdapter by lazy {
        MeiZiAdapter(this)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvList.apply {
            adapter = mAdapter
            val gridLayoutManager =
                GridLayoutManager(this@PicturesActivity, 2, GridLayoutManager.VERTICAL, false)
            layoutManager = gridLayoutManager
            addItemDecoration(MarginDecoration(left = 10, top = 10, right = 10, bottom = 10))
            addOnScrollListener(object : RecyclerView.OnScrollListener() {

                //用来标记是否正在向上滑动
                var isSlidingUp = false

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val lastVisiblePosition = gridLayoutManager.findLastCompletelyVisibleItemPosition()
                        val itemCount = gridLayoutManager.itemCount

                        // 判断是否滑动到了最后一个item，并且是向上滑动
                        if (lastVisiblePosition == (itemCount - 1) && isSlidingUp) {

                        }
                    }
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    // 大于0表示正在向上滑动，小于等于0表示停止或向下滑动
                    isSlidingUp = dy > 0
                }
            })
        }
    }

    override fun initData() {
        viewModel.meizisLiveData.observe(this, { result ->
            val meiZiList = result.getOrNull()
            if (meiZiList != null) {
                mAdapter.submitList(meiZiList)
            } else {
                Toast.makeText(this, "没拿到妹子！", Toast.LENGTH_SHORT).show()
                Log.d("aaaa", "initData: ${result.exceptionOrNull()}")
                result.exceptionOrNull()?.printStackTrace()
            }
        })

        viewModel.getMeiZis( 1)
    }
}