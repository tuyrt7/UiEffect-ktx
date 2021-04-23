package com.tuyrt.uieffect.module.components.recyclerview

import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityEffectParallaxBinding

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class ParallaxActivity : BaseActivity<NoViewModel, ActivityEffectParallaxBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_effect_parallax

    override fun initView(savedInstanceState: Bundle?) {

    }
}