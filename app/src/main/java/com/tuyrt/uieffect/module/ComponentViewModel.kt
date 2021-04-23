package com.tuyrt.uieffect.module

import com.tuyrt.uieffect.arch.BaseViewModel
import com.tuyrt.uieffect.module.extend.chart.ChartMainActivity
import com.tuyrt.uieffect.module.components.recyclerview.RecyclerMainActivity
import com.tuyrt.uieffect.module.components.statusbar.StatusMainActivity
import com.tuyrt.uieffect.module.components.timeline.TimelineActivity
import com.tuyrt.uieffect.data.model.ComponentItem
import com.tuyrt.uieffect.module.extend.mark.MarkActivity
import com.tuyrt.uieffect.module.tool.bitmap.BitmapMainActivity
import com.tuyrt.uieffect.module.extend.floats.FloatsMainActivity
import com.tuyrt.uieffect.module.extend.material.MaterialActivity

/**
 * Created by tuyrt7 on 2021/4/23.
 */
class ComponentViewModel : BaseViewModel() {

    val componentItemList = listOf(
        ComponentItem(1, "recycler", RecyclerMainActivity::class.java),
        ComponentItem(2, "timeline", TimelineActivity::class.java),
    )

    val toolItemList = listOf(
        ComponentItem(1, "statusbar", StatusMainActivity::class.java),
        ComponentItem(3, "bitmap", BitmapMainActivity::class.java),
    )

    val extendItemList = listOf(
        ComponentItem(1, "mark", MarkActivity::class.java),
        ComponentItem(2, "chart", ChartMainActivity::class.java),
        ComponentItem(3, "floats", FloatsMainActivity::class.java),
        ComponentItem(4, "material", MaterialActivity::class.java),

    )
}