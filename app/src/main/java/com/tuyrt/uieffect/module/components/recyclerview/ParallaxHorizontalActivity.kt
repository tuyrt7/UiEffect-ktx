package com.tuyrt.uieffect.module.components.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.module.components.recyclerview.adapter.ParallaxAdapter
import com.tuyrt.uieffect.module.components.recyclerview.decoration.ParallaxDecoration
import com.tuyrt.uieffect.databinding.ActivityRecyclerParallaxBinding

/**
 * Created by tuyrt7 on 2021/3/22.
 */
class ParallaxHorizontalActivity : BaseActivity<NoViewModel,ActivityRecyclerParallaxBinding>() {

    private val bgs = intArrayOf(
        R.drawable.rd_gua_seed_1, R.drawable.rd_gua_seed_2, R.drawable.rd_gua_seed_3,
        R.drawable.rd_gua_seed_4, R.drawable.rd_gua_seed_5, R.drawable.rd_gua_seed_6
    )

    private val listAdapter: ParallaxAdapter by lazy {
        ParallaxAdapter()
    }
    private var lastItemDecoration: RecyclerView.ItemDecoration? = null
    private var parallaxSize = .2f // 0.2 视差效果好
    private var autoFillBitmap = false

    override val layoutId: Int
        get() = R.layout.activity_recycler_parallax

    private fun fullScreen() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    override fun initView(savedInstanceState: Bundle?) {
        fullScreen()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ParallaxHorizontalActivity,RecyclerView.HORIZONTAL,false)
            setHasFixedSize(true)
            adapter = listAdapter
            lastItemDecoration = ParallaxDecoration(this.context).apply {
                setupResource(bgs.asList())
                parallax = parallaxSize
                autoFill = autoFillBitmap
            }
            addItemDecoration(lastItemDecoration!!)
        }

        binding.autoFillCb.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                updateItemDecoration(true)
            } else {
                updateItemDecoration(false)
            }
        }

        binding.parallaxSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    parallaxSize = progress * 1f / 100
                    binding.currentParallaxTv.text = "parallax:$parallaxSize"
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                updateItemDecoration(autoFillBitmap)
            }
        })
    }

    private fun updateItemDecoration(isAutoFill: Boolean) {
        if (lastItemDecoration != null) {
            binding.recyclerView.removeItemDecoration(lastItemDecoration!!)
        }
        autoFillBitmap = isAutoFill
        lastItemDecoration = ParallaxDecoration(this@ParallaxHorizontalActivity).apply {
            setupResource(bgs.asList())
            parallax = parallaxSize
            autoFill = autoFillBitmap
        }
        binding.recyclerView.addItemDecoration(lastItemDecoration!!)
    }
}