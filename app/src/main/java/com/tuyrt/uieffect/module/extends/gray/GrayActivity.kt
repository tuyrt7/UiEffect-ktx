package com.tuyrt.uieffect.module.extends.gray

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityGrayMainBinding
import com.tuyrt.uieffect.ext.addFragment

/**
 * Created by tuyrt7 on 2021/11/30.
 * 说明： 页面全局、局部灰度化
 */
class GrayActivity : BaseActivity<NoViewModel, ActivityGrayMainBinding>() {

    override val layoutId: Int = R.layout.activity_gray_main

    override fun onCreate(savedInstanceState: Bundle?) {
        setGrayDecorView()
        super.onCreate(savedInstanceState)
    }

    override fun initView(savedInstanceState: Bundle?) {
        addFragment(R.id.content, GrayFragment())
    }

    /**
     * 第一种方案(失效)： 替换Activity根布局 android.id.content 对应的FrameLayout为GrayFrameLayout
     * 把下方代码复制到BaseActivity中，实现所有的页面添加灰色调样式
     * 还有一些特殊细节问题需要根据实际情况处理：
     * -  Activity的window设置background,咋办？
     * -  theme中设置windowBackground,就需要从theme中提取drawable
     * -  dialog 支持吗？
     * -  android.R.id.content失宠了，不是FrameLayout ？
     * -
     * -  注意 webView和视频播放有些问题 ？
     */
    /*@SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        if ("FrameLayout" == name) {
            val count = attrs.attributeCount
            for (i in 0 until count) {
                val attributeName = attrs.getAttributeName(i)
                val attributeValue = attrs.getAttributeValue(i)
                if (attributeName == "id") {
                    val id = attributeValue.substring(1).toInt()
                    val idVal = resources.getResourceName(id)
                    if ("android:id/content" == idVal) {
                        val grayFrameLayout = GrayFrameLayout(context, attrs)
                        //Activity的window设置background,咋办？
                        //grayFrameLayout.setBackgroundDrawable(getWindow().getDecorView().getBackground());
                        //theme中设置windowBackground ？
                        val a = TypedValue()
                        theme.resolveAttribute(android.R.id.content, a, true)
                        if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT) {
                            //windowBackground is a color
                            val color = a.data
                            grayFrameLayout.setBackgroundColor(color)
                        } else {
                            //windowBackground is not a color,probably a drawable
                            val drawable = resources.getDrawable(a.resourceId)
                            grayFrameLayout.background = drawable
                        }
                        return grayFrameLayout
                    }
                }
            }
        }
        return super.onCreateView(name, context, attrs)
    }*/


    /**
     * 第二种方案： 通过硬件绘制会调用的API，view.setLayerType(layerType,null);直接在BaseActivity中获取decorView
     * 对象，然后设置硬件绘制灰色调 （依赖硬件加速，）
     *
     * 使用：
     * override fun onCreate(savedInstanceState: Bundle?) {
     *      setGrayDecorView()
     *      super.onCreate(savedInstanceState)
     * }
     */
    private fun setGrayDecorView() {
        val mPaint = Paint()
        val cm = ColorMatrix()
        cm.setSaturation(0f)
        mPaint.colorFilter = ColorMatrixColorFilter(cm)
        window.decorView.setLayerType(View.LAYER_TYPE_HARDWARE, mPaint)
    }
}