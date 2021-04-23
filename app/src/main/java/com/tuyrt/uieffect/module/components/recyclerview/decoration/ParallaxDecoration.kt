package com.tuyrt.uieffect.module.components.recyclerview.decoration

import android.app.ActivityManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import androidx.recyclerview.widget.RecyclerView

/**
 * recyclerView的特殊项装饰，它可以将弯针显示的任何位图显示为recyclerView的背景。
 * 背景的位图可以选择在此recyclerView中以视差方式滚动。请注意，所有位图都必须具有相同的大小。
 * 如果要自定义项目装饰，请扩展此类并重
 * 
 * RecyclerView 视差装饰器
 */
open class ParallaxDecoration(private val context: Context) : RecyclerView.ItemDecoration() {
    private var screenWidth = 0
    private var screenHeight = 0
    private var maxVisibleCount = 0
    private var minVisibleCount = 0
    private var bitmapCount = 0
    private var bitmapWidth = 0
    private var bitmapHeight = 0
    private lateinit var bitmapOptions: BitmapFactory.Options
    private var isHorizontal = true

    /**
     * 要滚动的视差百分比
     */
    var parallax: Float = 1.0f

    /**
     * 是否自动缩放位图以填充画布的大小
     */
    var autoFill = false

    private var am: ActivityManager? = null
    private var bitmapPool = mutableListOf<Bitmap>()
    private var scale = 1f
    private var scaleBitmapWidth = 0
    private var scaleBitmapHeight = 0

    /**
     *  初始化 bitmaps 绘制背景
     */
    fun setupBitmap(bitmaps: List<Bitmap>) {
        bitmapPool.clear()
        bitmapPool.addAll(bitmaps)
        updateConfig()
    }

    fun addBitmap(bitmap: Bitmap) {
        bitmapPool.add(bitmap)
        updateConfig()
    }

    /**
     *  初始化 本地drawables资源 绘制背景
     */
    fun setupResource(resources: List<Int>) {
        bitmapPool.clear()
        for (resourceId in resources) {
            bitmapPool.add(decodeBitmap(resourceId))
        }
        updateConfig()
    }

    fun addResource(resourceId: Int) {
        bitmapPool.add(decodeBitmap(resourceId))
        updateConfig()
    }

    private fun decodeBitmap(resourceId: Int): Bitmap {
        if (am == null) {
            bitmapOptions = BitmapFactory.Options()
            am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            if (am!!.isLowRamDevice) {
                bitmapOptions.inPreferredConfig = Bitmap.Config.RGB_565
            }
        }
        return BitmapFactory.decodeResource(context.resources, resourceId, bitmapOptions)

    }

    private fun updateConfig() {
        bitmapCount = bitmapPool.size
        bitmapWidth = bitmapPool[0].width
        bitmapHeight = bitmapPool[0].height
        scaleBitmapWidth = bitmapWidth
        scaleBitmapHeight = bitmapHeight

        //检查位图的宽度和高度
        bitmapPool.forEach {
            if (it.width != bitmapWidth || it.height != bitmapHeight) {
                throw RuntimeException("Every bitmap of backgounds must has the same size!")
            }
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        if (bitmapPool.isNotEmpty()) {
            // if layoutManager is null, just throw exception
            val lm = parent.layoutManager!!
            // step1. check orientation
            isHorizontal = lm.canScrollHorizontally()
            // step2. check maxVisible count
            // step3. if autoFill ,calculate the scale bitmap size
            if (screenWidth == 0 || screenHeight == 0) {
                screenWidth = c.width
                screenHeight = c.height

                //完全可见的图片数量 = 屏幕宽度 / 单张图片宽度
                val allInScreen: Int
                //是否有 两边都超出屏幕的图片
                val doubleOutOfScreen: Boolean
                if (isHorizontal) {
                    if (autoFill) {
                        scale = screenHeight * 1f / bitmapHeight
                        scaleBitmapWidth = (bitmapWidth * scale).toInt()
                    }
                    allInScreen = screenWidth / scaleBitmapWidth
                    doubleOutOfScreen = screenWidth % scaleBitmapWidth > 1
                } else {
                    if (autoFill) {
                        scale = screenWidth * 1f / bitmapWidth
                        scaleBitmapHeight = (bitmapHeight * scale).toInt()
                    }
                    allInScreen = screenHeight / scaleBitmapHeight
                    doubleOutOfScreen = screenHeight % scaleBitmapHeight > 1
                }
                // 剩余像素 > 1px == （总可见图片数量 = 完全可见的图片数量 + 2)
                minVisibleCount = allInScreen + 1
                maxVisibleCount = if (doubleOutOfScreen) allInScreen + 2 else minVisibleCount
            }

            // step4. find the firstVisible index
            // step5. calculate the firstVisible offset
            val parallaxOffset: Float
            val firstVisible: Int
            val firstVisibleOffset: Float
            if (isHorizontal) {
                // 图片背景滑动距离 = 当前recyclerView的滑动距离 * 视差比
                parallaxOffset = lm.computeHorizontalScrollOffset(state) * parallax
                // 滑动距离 / 单张图片宽度 = 当前是第几张图片
                // 这里我们对图片集合的长度进行求余运算，即可获得当前第一个可见的图片索引
                firstVisible = (parallaxOffset / scaleBitmapWidth).toInt()
                // 获取当前第一张图片左边缘距离屏幕左边缘的偏移量
                firstVisibleOffset = parallaxOffset % scaleBitmapWidth
            } else {
                parallaxOffset = lm.computeVerticalScrollOffset(state) * parallax
                firstVisible = (parallaxOffset / scaleBitmapHeight).toInt()
                firstVisibleOffset = parallaxOffset % scaleBitmapHeight
            }

            /**
             * 我们确定了当前屏幕第一张可见的图片索引，以及第一张图片与屏幕左边缘的偏移量，
             * 获取绘制数目优化取值bestDrawCount
             * 下面就可以开始真正的绘制了（计算最终绘出）
             */

            // step6. calculate the best draw count
            val bestDrawCount =
                if (firstVisibleOffset.toInt() == 0) minVisibleCount else maxVisibleCount
            // step7. translate to firstVisible offset
            c.save()
            if (isHorizontal) {
                // 把画布平移到第一张图片的左边缘
                c.translate(-firstVisibleOffset, 0f)
            } else {
                c.translate(0f, -firstVisibleOffset)
            }
            // step8. if autoFill, scale the canvas to draw
            if (autoFill) {
                c.scale(scale, scale)
            }
            // step9. draw from current first visible bitmap, the max looper count is the best draw count by step6
            for ((i, currentIndex) in (firstVisible until firstVisible + bestDrawCount).withIndex()) {
                //i 从0起，currentIndex从 firstVisible 起
                if (isHorizontal) {
                    c.drawBitmap(
                        bitmapPool[currentIndex % bitmapCount],
                        i * bitmapWidth.toFloat(),
                        0f,
                        null
                    )
                } else {
                    c.drawBitmap(
                        bitmapPool[currentIndex % bitmapCount],
                        0f,
                        i * bitmapHeight.toFloat(),
                        null
                    )
                }
            }
            // 恢复画布
            c.restore()
        }
    }
}