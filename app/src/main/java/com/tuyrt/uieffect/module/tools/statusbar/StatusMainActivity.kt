package com.tuyrt.uieffect.module.tools.statusbar

import android.content.Intent
import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityStatusMainBinding

/**
 * Created by tuyrt7 on 2021/4/21.
 */
class StatusMainActivity() : BaseActivity<NoViewModel, ActivityStatusMainBinding>() {

    override val layoutId: Int = R.layout.activity_status_main

    override fun initView(savedInstanceState: Bundle?) {
        binding.fullScreen.setOnClickListener {
            startActivity(Intent(this, FullScreenActivity::class.java))
        }

        binding.fullScreenWithText.setOnClickListener {
            startActivity(Intent(this, FullScreenWithTextActivity::class.java))
        }

        binding.sameColorWithTitleBar.setOnClickListener {
            startActivity(Intent(this, FullscreenWithTitleBarActivity::class.java))
        }

        binding.switchStatus.setOnClickListener {
            startActivity(Intent(this, SwitchStatusActivity::class.java))
        }
    }
}