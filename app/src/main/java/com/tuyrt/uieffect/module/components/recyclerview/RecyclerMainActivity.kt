package com.tuyrt.uieffect.module.components.recyclerview

import android.content.Intent
import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityRecyclerMainBinding

/**
 * Created by tuyrt7 on 2021/4/21.
 */
class RecyclerMainActivity() : BaseActivity<NoViewModel,ActivityRecyclerMainBinding>() {

    override val layoutId: Int = R.layout.activity_recycler_main

    override fun initView(savedInstanceState: Bundle?) {

        binding.btnPic.setOnClickListener {
            startActivity(Intent(this, PicturesActivity::class.java))
        }

        binding.btnTouchDelete.setOnClickListener {
            startActivity(Intent(this, SwipeActivity::class.java))
        }

        binding.btnDrag.setOnClickListener {
            startActivity(Intent(this, DragActivity::class.java))
        }

        binding.btnParallaxH.setOnClickListener {
            startActivity(Intent(this, ParallaxHorizontalActivity::class.java))
        }
        binding.btnParallaxV.setOnClickListener {
            startActivity(Intent(this, ParallaxVerticalActivity::class.java))
        }
        binding.btnParallax.setOnClickListener {
            startActivity(Intent(this, ParallaxActivity::class.java))
        }

        binding.btnCity.setOnClickListener {
            startActivity(Intent(this, CitiesActivity::class.java))
        }
    }
}