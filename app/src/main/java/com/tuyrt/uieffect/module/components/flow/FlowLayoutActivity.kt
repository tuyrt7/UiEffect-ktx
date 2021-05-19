package com.tuyrt.uieffect.module.components.flow

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityFlowLayoutBinding


/**
 * Created by tuyrt7 on 2021/5/19.
 */
class FlowLayoutActivity : BaseActivity<NoViewModel, ActivityFlowLayoutBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_flow_layout

    override fun initView(savedInstanceState: Bundle?) {
        val flKeyword = binding.flKeyword

        // 关键字集合
        val list: MutableList<String> = ArrayList()
        list.add("关键词一")
        list.add("关二")
        list.add("关键词三词")
        list.add("关四词")
        list.add("关")

        // 设置文字大小
        flKeyword.setTextSize(15)
        // 设置文字颜色
        flKeyword.setTextColor(Color.BLACK)
        // 设置文字背景
        flKeyword.setTagBackgroundResource(R.drawable.flow_tag_bg)

        // 设置文字水平margin
        flKeyword.setHorizontalSpacing(15)
        // 设置文字垂直margin
        flKeyword.setVerticalSpacing(15)

        // 设置文字水平padding
        flKeyword.setTextPaddingH(15)
        // 设置文字垂直padding
        flKeyword.setTextPaddingV(8)

        // 设置UI与点击事件监听
        // 最后调用setViews方法
        flKeyword.setViews(list) { content ->
            Toast.makeText(this@FlowLayoutActivity, content, Toast.LENGTH_SHORT).show()
        }

        // 增加关键字
        flKeyword.addView("关键字六"){ content ->
             Toast.makeText(this@FlowLayoutActivity, content, Toast.LENGTH_SHORT).show()
        }
    }

}