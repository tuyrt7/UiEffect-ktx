package com.tuyrt.uieffect.module.tools.bitmap

import android.content.Intent
import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityBitmapMainBinding
import com.tuyrt.uieffect.utils.ScreenUtils

/**
 * Created by tuyrt7 on 2021/4/23.
 */
class BitmapMainActivity : BaseActivity<NoViewModel, ActivityBitmapMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_bitmap_main

    override fun initView(savedInstanceState: Bundle?) {
        binding.btnBitmap.setOnClickListener { startActivity(Intent(this, BitmapActivity::class.java)) }
        binding.btnGlide.setOnClickListener { startActivity(Intent(this, GlideActivity::class.java)) }
        binding.btnSubsampling.setOnClickListener { startActivity(Intent(this, SubSamplingActivity::class.java)) }
        binding.btnFunc.setOnClickListener { startActivity(Intent(this, FunctionActivity::class.java)) }

        ScreenUtils.showScreenInfo(this)
    }

}