package com.tuyrt.uieffect.module.components.waveview

import android.os.Bundle
import android.os.SystemClock
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityWaveBinding
import java.util.*
import kotlin.concurrent.thread

/**
 * Created by tuyrt7 on 2021/5/19.
 */
class WaveActivity:BaseActivity<NoViewModel, ActivityWaveBinding>() {
    val waveView by lazy {
        binding.waveView
    }
    val waveLineView by lazy {
        binding.waveLineView
    }

    val random by lazy {
        Random()
    }

    private var flag = true

    override val layoutId: Int
        get() = R.layout.activity_wave

    override fun initView(savedInstanceState: Bundle?) {
        thread {
            // 模拟取值
            while (flag) {
                SystemClock.sleep(30)
                // 取值 -300 ~ 300
                val short = (random.nextInt(600) - 300).toShort()
                // 取值 0 ~ 100
                val volume = random.nextInt(100)
                runOnUiThread {
                    waveView.addData(short)
                    waveLineView.setVolume(volume)
                }
            }
        }

        waveLineView.startAnim()
    }

    override fun onDestroy() {
        flag = false
        waveLineView.stopAnim()
        super.onDestroy()
    }
}