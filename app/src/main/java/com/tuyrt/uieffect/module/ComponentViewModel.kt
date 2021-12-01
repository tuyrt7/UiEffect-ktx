package com.tuyrt.uieffect.module

import com.tuyrt.uieffect.arch.BaseViewModel
import com.tuyrt.uieffect.module.extends.chart.ChartMainActivity
import com.tuyrt.uieffect.module.components.recyclerview.RecyclerMainActivity
import com.tuyrt.uieffect.module.tools.statusbar.StatusMainActivity
import com.tuyrt.uieffect.module.components.timeline.TimelineActivity
import com.tuyrt.uieffect.data.model.ComponentItem
import com.tuyrt.uieffect.module.components.button.ButtonActivity
import com.tuyrt.uieffect.module.components.flow.FlowLayoutActivity
import com.tuyrt.uieffect.module.components.waveview.WaveActivity
import com.tuyrt.uieffect.module.extends.mark.MarkActivity
import com.tuyrt.uieffect.module.tools.bitmap.BitmapMainActivity
import com.tuyrt.uieffect.module.extends.floats.FloatsMainActivity
import com.tuyrt.uieffect.module.extends.gray.GrayActivity
import com.tuyrt.uieffect.module.extends.material.MaterialActivity

/**
 * Created by tuyrt7 on 2021/4/23.
 */
class ComponentViewModel : BaseViewModel() {

    val componentItemList = listOf(
        ComponentItem(1, "Recycler", RecyclerMainActivity::class.java),
        ComponentItem(2, "Timeline", TimelineActivity::class.java),
        ComponentItem(3, "Flowlayout", FlowLayoutActivity::class.java),
        ComponentItem(4, "Wave", WaveActivity::class.java),
        ComponentItem(5, "Button", ButtonActivity::class.java),
    )

    val toolItemList = listOf(
        ComponentItem(1, "statusbar", StatusMainActivity::class.java),
        ComponentItem(3, "bitmap", BitmapMainActivity::class.java),
    )

    val extendItemList = listOf(
        ComponentItem(1, "mark", MarkActivity::class.java),
        ComponentItem(2, "chart", ChartMainActivity::class.java),
        ComponentItem(3, "floats", FloatsMainActivity::class.java),
        ComponentItem(4, "material+toolbar", MaterialActivity::class.java),
        ComponentItem(5, "Gray灰度化", GrayActivity::class.java),

    )
}