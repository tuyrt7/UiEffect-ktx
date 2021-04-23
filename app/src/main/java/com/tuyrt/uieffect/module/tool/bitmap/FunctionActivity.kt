package com.tuyrt.uieffect.module.tool.bitmap

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityBitmapFunctionBinding
import com.tuyrt.uieffect.utils.Bitmaps

/**
 * Created by tuyrt7 on 2021/4/23.
 * 图片 镜像x,y 旋转 缩小（大小，比例） 裁剪（大小，圆形）
 */
class FunctionActivity:BaseActivity<NoViewModel,ActivityBitmapFunctionBinding>() {

    lateinit var bitmap: Bitmap

    override val layoutId: Int
        get() = R.layout.activity_bitmap_function

    override fun initView(savedInstanceState: Bundle?) {
        bitmap = BitmapFactory.decodeStream(assets.open("bitmap/pic2.jpg"))
        binding.ivPic.setImageBitmap(bitmap)
        log("bitmap ${bitmap.width} * ${bitmap.height}")

        binding.btMirrorX.setOnClickListener {
            bitmap = Bitmaps.mirrorX(bitmap)
            binding.ivPic.setImageBitmap(bitmap)
        }

        binding.btMirrorY.setOnClickListener {
            bitmap = Bitmaps.mirrorY(bitmap)
            binding.ivPic.setImageBitmap(bitmap)
        }

        binding.btRoate.setOnClickListener {
            bitmap = Bitmaps.rotate(bitmap, 90f)
            log("bitmap ${bitmap.width} * ${bitmap.height}")
            binding.ivPic.setImageBitmap(bitmap)
        }

        binding.btnScale.setOnClickListener {
            bitmap = Bitmaps.scale(bitmap, 0.5f)
            log("bitmap ${bitmap.width} * ${bitmap.height}")
            binding.ivPic.setImageBitmap(bitmap)
        }

        binding.btnScaleToSize.setOnClickListener {
            bitmap = Bitmaps.scale(bitmap, 300, 500)
            log("bitmap ${bitmap.width} * ${bitmap.height}")
            binding.ivPic.setImageBitmap(bitmap)
        }

        binding.btnCorp.setOnClickListener {
            bitmap = Bitmaps.crop(bitmap, 500, 800)
            log("bitmap ${bitmap.width} * ${bitmap.height}")
            binding.ivPic.setImageBitmap(bitmap)
        }

        binding.btnCircle.setOnClickListener {
            bitmap = Bitmaps.cropCircle(bitmap, 400)
            log("bitmap ${bitmap.width} * ${bitmap.height}")
            binding.ivPic.setImageBitmap(bitmap)
        }
    }
}