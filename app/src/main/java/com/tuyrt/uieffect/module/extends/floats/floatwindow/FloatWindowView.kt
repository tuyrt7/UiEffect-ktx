package com.tuyrt.uieffect.module.extends.floats.floatwindow

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.module.extends.chart.ChartMainActivity

/**
 *
 */
class FloatWindowView(context: Context) : LinearLayout(context) {

    companion object {
        var viewWidth: Int = 0     //小悬浮窗的宽高
        var viewHeight: Int = 0
        var statusBarHeight = 0    //系统状态栏的高度
    }

    private var mWindowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private lateinit var mLayoutParams: WindowManager.LayoutParams


    private var currentX = 0f //当前手指位置在屏幕上的坐标
    private var currentY = 0f

    private var downX = 0f //手指按下时在屏幕上的坐标
    private var downY = 0f

    private var xInView = 0f //手指按下时小悬浮窗在屏幕上的坐标
    private var yInView = 0f


    init {
        statusBarHeight = FloatWindowManager.getStatusBarHeight(context)
        LayoutInflater.from(context).inflate(R.layout.view_float_window_small, this)
        val smallWindowLayout = findViewById<LinearLayout>(R.id.small_window_layout)
        val tvPercent = findViewById<TextView>(R.id.tvPercent)
        viewWidth = smallWindowLayout.layoutParams.width
        viewHeight = smallWindowLayout.layoutParams.height
        tvPercent.text = "悬浮窗"
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                // 手指按下时记录必要数据,纵坐标的值都需要减去状态栏高度
                xInView = event.x
                yInView = event.y

                downX = event.rawX
                downY = event.rawY - statusBarHeight

                currentX = event.rawX
                currentY = event.rawY - statusBarHeight

            }
            MotionEvent.ACTION_MOVE -> {
                currentX = event.rawX
                currentY = event.rawY - statusBarHeight

                // 手指移动的时候更新小悬浮窗的位置
                updateViewPosition()
            }
            MotionEvent.ACTION_UP -> {
                // 如果手指离开屏幕时，currentX和downX相等，且currentY 和downY相等，则视为触发了单击事件。
                if (currentX == downX && currentY == downY) {
                    Toast.makeText(context, "点击", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, ChartMainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(intent)
                }
            }
            MotionEvent.ACTION_OUTSIDE -> {
//                Toast.makeText(context,"ACTION_OUTSIDE",0).show()
            }
        }

        return true
    }

    /**
     * 更新小悬浮窗的位置
     */
    private fun updateViewPosition() {
        //mLayoutParams.x = ((currentX - xInView).toInt())
        mLayoutParams.y = ((currentY - yInView).toInt())
        mWindowManager.updateViewLayout(this, mLayoutParams)
    }


    private fun openBigWindow() {
    }


    /**
     * 将小悬浮窗的参数传入，用于更新小悬浮窗的位置
     */
    fun setParams(params: WindowManager.LayoutParams) {
        this.mLayoutParams = params
    }


}