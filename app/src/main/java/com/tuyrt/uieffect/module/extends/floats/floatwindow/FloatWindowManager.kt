package com.tuyrt.uieffect.module.extends.floats.floatwindow

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PixelFormat
import android.graphics.Point
import android.os.Build
import android.view.Gravity
import android.view.WindowManager
import com.tuyrt.uieffect.utils.HiDisplayUtils
import com.tuyrt.uieffect.utils.LogUtils


/**
 *
 * author : ChenSen
 * data : 2019/6/6
 * desc:
 */
object FloatWindowManager {

    var isShowing = false

    private var view: FloatWindowView? = null
    private var smallViewParam: WindowManager.LayoutParams? = null
    private var windowManager: WindowManager? = null

    @SuppressLint("ClickableViewAccessibility")
    fun createWindowView(context: Context) {

        if (windowManager == null) {
            windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }

        if (view == null) {

            val point = Point()
            windowManager?.defaultDisplay?.getSize(point)
            val screenWidth = point.x
            val screenHeight = point.y
            LogUtils.d("screenWidth $screenWidth  screenHeight $screenHeight ")

            view = FloatWindowView(context)
            smallViewParam = WindowManager.LayoutParams()

            // 设置窗体显示类型 兼容Android 8及以上
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                smallViewParam?.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            else
                smallViewParam?.type = WindowManager.LayoutParams.TYPE_PHONE;
            smallViewParam?.format = PixelFormat.RGBA_8888
            smallViewParam?.flags =
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            smallViewParam?.width = FloatWindowView.viewWidth
            smallViewParam?.height = FloatWindowView.viewHeight
            smallViewParam?.gravity = Gravity.START or Gravity.TOP
            smallViewParam?.x = screenWidth - FloatWindowView.viewWidth - HiDisplayUtils.dp2px(20f,context.resources)
            smallViewParam?.y = HiDisplayUtils.dp2px(100f,context.resources)
            view?.setParams(smallViewParam!!)
            windowManager?.addView(view, smallViewParam)
        } else {
            view?.setParams(smallViewParam!!)
            windowManager?.addView(view, smallViewParam)
        }
        isShowing = true
    }


    fun removeSmallWindow(context: Context) {
        if (view != null) {
            windowManager?.removeView(view)
            view = null
            isShowing = false
        }
    }

    fun getStatusBarHeight(context: Context): Int {
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        val height = context.resources.getDimensionPixelSize(resourceId)
        LogUtils.d("状态栏高度 $height")
        return height
    }
}