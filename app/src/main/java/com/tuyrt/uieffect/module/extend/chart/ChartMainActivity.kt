package com.tuyrt.uieffect.module.extend.chart

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.module.extend.chart.fragment.BrokenLineFragment
import com.tuyrt.uieffect.module.extend.chart.fragment.RadarFragment
import com.tuyrt.uieffect.data.model.FragmentItem
import com.tuyrt.uieffect.databinding.ActivityChartMainBinding

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class ChartMainActivity : BaseActivity<NoViewModel, ActivityChartMainBinding>() {

    var fragmentItems = arrayListOf(
        FragmentItem(RadarFragment(), "雷达图"),
        FragmentItem(BrokenLineFragment(), "折线图")
    )

    private val viewPager by lazy {
        binding.viewPager
    }
    private val tabLayout by lazy {
        binding.tabLayout
    }

    override val layoutId: Int
        get() = R.layout.activity_chart_main

    override fun initView(savedInstanceState: Bundle?) {
        binding.viewPager.adapter =
            object : FragmentStateAdapter(supportFragmentManager, lifecycle) {
                override fun getItemCount() = fragmentItems.size

                override fun createFragment(position: Int): Fragment {
                    return fragmentItems[position].fragment
                }
            }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentItems[position].title
        }.attach()
    }
}