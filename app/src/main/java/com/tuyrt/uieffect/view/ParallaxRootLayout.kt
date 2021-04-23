package com.tuyrt.uieffect.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.animation.OvershootInterpolator
import android.widget.LinearLayout
import com.tuyrt.uieffect.R
import kotlin.math.atan
import kotlin.math.tan

/**
 * Created by tuyrt7 on 2021/3/22.
 */
class ParallaxRootLayout @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attr, defStyleAttr) {

    companion object {
        private const val TAG = "ParallaxRootLayout"
    }

    private var angle = 0f
    private var width = 0f
    private var height = 0f
    private var path1: Path? = null
    private var path2: Path? = null
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.i(TAG, "onSizeChanged: $w x $h")
        width = w.toFloat()
        height = h.toFloat()
        path1 = Path()
        path2 = Path()

//        path1 = Path().apply {
//            moveTo(width * 0.1f, 0f)
//            lineTo(width, 0f)
//            lineTo(width, height * 0.3f)
//            lineTo(width * 0.1f, height * 0.5f)
//            close()
//        }
//        path2 = Path().apply {
//            moveTo(0f, height * 0.7f)
//            lineTo(0f, height)
//            lineTo(width * 0.9f, height)
//            lineTo(width * 0.9f, height * 0.5f)
//            close()
//        }

        angle = atan(height * 0.2f / width)
    }

    private val anim = ValueAnimator.ofFloat(0f,1f).apply {
        duration = 1200
        interpolator = OvershootInterpolator(1.5f)
        addUpdateListener {
            val percent = it.animatedValue as Float
            path1?.apply {
                val r = 1.1f - percent
                reset()
                moveTo(width, 0f)
                lineTo(width, height * 0.3f)
                lineTo(width * r, height * 0.3f + tan(angle) * width * percent)
                lineTo(width * r, 0f)
                close()
            }

            path2?.apply {
                reset()
                moveTo(0f, height * 0.7f)
                lineTo(0f,height)
                lineTo(width * 0.9f * percent, height)
                lineTo(width * 0.9f * percent, height * 0.7f - tan(angle) * width * 0.9f * percent)
                close()
            }
            invalidate()
        }
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        anim.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (anim.isRunning) {
            anim.end()
            anim.cancel()
        }
    }

    override fun dispatchDraw(canvas: Canvas?) {
        canvas!!.drawColor(resources.getColor(R.color.teal_200))
        path1?.run {
            paint.color = resources.getColor(R.color.purple_500)
            canvas.drawPath(this, paint)
        }

        path2?.run {
            paint.color = resources.getColor(R.color.purple_700)
            canvas.drawPath(this, paint)
        }
        super.dispatchDraw(canvas)
    }
}