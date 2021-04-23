package com.tuyrt.uieffect.utils

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.util.Log

class ScreenUtils {

    companion object {

        fun showScreenInfo(context: Activity) {
            val displayMetrics = DisplayMetrics()
            context.windowManager.defaultDisplay.getMetrics(displayMetrics)

            Log.e("tag", "screen size: ${displayMetrics.widthPixels} * ${displayMetrics.heightPixels}  \n" +
                    "screen density: ${displayMetrics.density} \n" +
                    "screen densityDpi: ${displayMetrics.densityDpi} \n" +
                    "screen scaledDensity: ${displayMetrics.scaledDensity} \n")
        }

    }
}