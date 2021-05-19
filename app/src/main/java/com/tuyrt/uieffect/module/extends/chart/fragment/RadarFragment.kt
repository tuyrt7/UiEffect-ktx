package com.tuyrt.uieffect.module.extends.chart.fragment

import android.os.Bundle
import android.widget.SeekBar
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseFragment
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.FragmentChartRaderBinding
import com.tuyrt.uieffect.view.RadarView
import java.util.*

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class RadarFragment : BaseFragment<NoViewModel, FragmentChartRaderBinding>() {

    private val radarView: RadarView by lazy {
        binding.radarView
    }

    override val layoutId: Int
        get() = R.layout.fragment_chart_rader

    override fun initView(savedInstanceState: Bundle?) {
        var mTitles = ArrayList<String>()
        mTitles.add("生存")
        mTitles.add("团战")
        mTitles.add("发育")
        mTitles.add("输出")
        mTitles.add("推进")
        mTitles.add("战绩(KDA)")

        var mData = ArrayList<Double>()
        mData.add(60.0)
        mData.add(100.0)
        mData.add(45.0)
        mData.add(85.0)
        mData.add(99.0)
        mData.add(66.0)

        radarView.setTitles(mTitles)
        radarView.setData(mData)


        binding.seek1.progress = mData[0].toInt()
        binding.seek2.progress = mData[1].toInt()
        binding.seek3.progress = mData[2].toInt()
        binding.seek4.progress = mData[3].toInt()
        binding.seek5.progress = mData[4].toInt()
        binding.seek6.progress = mData[5].toInt()

        binding.seek1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mData[0] = progress.toDouble()
                radarView.setData(mData)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        binding.seek2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mData[1] = progress.toDouble()
                radarView.setData(mData)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        binding.seek3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mData[2] = progress.toDouble()
                radarView.setData(mData)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        binding.seek4.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mData[3] = progress.toDouble()
                radarView.setData(mData)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        binding.seek5.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mData[4] = progress.toDouble()
                radarView.setData(mData)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        binding.seek6.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mData[5] = progress.toDouble()
                radarView.setData(mData)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}