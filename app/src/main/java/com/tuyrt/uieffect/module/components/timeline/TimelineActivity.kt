package com.tuyrt.uieffect.module.components.timeline

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.module.components.recyclerview.decoration.StepItemDecoration
import com.tuyrt.uieffect.databinding.ActivityTimelineBinding
import java.util.ArrayList

/**
 * Created by tuyrt7 on 2021/4/22.
 */
class TimelineActivity:BaseActivity<NoViewModel,ActivityTimelineBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_timeline

    override fun initView(savedInstanceState: Bundle?) {
        val dataList = ArrayList<String>()
        val timeList = ArrayList<String>()

        dataList.add("卖家发货")
        dataList.add("到达【义乌中心】")
        dataList.add("离开【义乌中心】,下一站【郑州汽转】")
        dataList.add("您的快件已被HN丰巢【自取柜】代收,请及时取件。如有问题请联系派件员13888888888")
        dataList.add("已签收，签收人凭取货码签收。感谢使用丰巢 【自取柜】,期待再次为您服务。")

        timeList.add("2018-03-02 20:45:13")
        timeList.add("2018-03-02 07:15:13")
        timeList.add("2018-03-03 20:45:13")
        timeList.add("2018-03-04 08:55:23")
        timeList.add("2018-03-04 12:28:15")

        dataList.reverse()
        timeList.reverse()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = TimelineAdapter(context, dataList, timeList)
            addItemDecoration(StepItemDecoration(context))
        }
    }
}