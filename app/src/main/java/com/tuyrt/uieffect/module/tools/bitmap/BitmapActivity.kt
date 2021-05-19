package com.tuyrt.uieffect.module.tools.bitmap

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityBitmapBitmapBinding
import com.tuyrt.uieffect.utils.Bitmaps
import com.tuyrt.uieffect.utils.FileUtils
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

/**
 * Created by tuyrt7 on 2021/4/23.
 */
class BitmapActivity : BaseActivity<NoViewModel, ActivityBitmapBitmapBinding>() {

    private val mHandler = Handler {
        true
    }

    override val layoutId: Int
        get() = R.layout.activity_bitmap_bitmap

    override fun initView(savedInstanceState: Bundle?) {
//        savePicToDisk() //保存图片到本地
        // 从 assets 中加载图片
        binding.btnFormAssets.setOnClickListener {
            val bytes = assets.open("bitmap/pic.jpg").readBytes()

            val options = BitmapFactory.Options()
            options.inSampleSize = 2
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size, options)
            binding.ivPic.setImageBitmap(bitmap)

            log("从 assets 中加载图片：")
            showInfo(bitmap)
        }

        // 从 Drawable 中加载图片
        binding.btnFromDrawable.setOnClickListener {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.pic)
            binding.ivPic.setImageBitmap(bitmap)

            log("从 drawable 中加载图片：")
            showInfo(bitmap)
        }


        //压缩图片：质量压缩
        binding.btnQualityCompress.setOnClickListener {
            //加载原始图片
            val rawBytes = assets.open("bitmap/pic.jpg").readBytes()
            val bitmap = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size)
            binding.ivPic.setImageBitmap(bitmap)
            log("从 assets 中加载图片并压缩：")

            //压缩图片：质量压缩
            val bytes = Bitmaps.compressQuality(bitmap, 100)
            val compressedBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

            //保存压缩的图片
            val compressedFile =
                File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "compressedImage.jpg")
            FileUtils.writeToFile(bytes, compressedFile)

            // 展示结果
            showCompressInfo(bitmap, compressedBitmap, compressedFile)
            mHandler.postDelayed({
                binding.ivPic.setImageBitmap(compressedBitmap) // 5s 后展示压缩过的图片
            }, 3000)
        }

        //压缩图片：采样率压缩
        binding.btnInSampleCompress.setOnClickListener {
            //加载原始图片
            val rawBytes = assets.open("bitmap/pic.jpg").readBytes()
            val bitmap = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size)
            binding.ivPic.setImageBitmap(bitmap)
            log("从 assets 中加载图片并压缩：")

            //压缩图片：采样率压缩
            val compressedBytes = Bitmaps.compressInSampleSize(rawBytes, 500, 500)
            val compressedBitmap =
                BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes.size)

            //保存压缩的图片
            val compressedFile =
                File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "compressedImage.jpg")
            FileUtils.writeToFile(compressedBytes, compressedFile)

            // 展示结果
            showCompressInfo(bitmap, compressedBitmap, compressedFile)
            mHandler.postDelayed({
                binding.ivPic.setImageBitmap(compressedBitmap) // 5s 后展示压缩过的图片
            }, 3000)
        }

        //压缩图片：缩放压缩
        binding.btnScaleCompress.setOnClickListener {
            //加载原始图片
            val rawBytes = assets.open("bitmap/pic.jpg").readBytes()
            val bitmap = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size)
            binding.ivPic.setImageBitmap(bitmap)
            log("从 assets 中加载图片并压缩：")

            // 压缩
            val compressedBitmap = Bitmaps.compressScale(bitmap, 500, 500)

            //保存压缩的图片
            val compressedFile =
                File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "compressedImage.jpg")
            FileUtils.writeToFile(Bitmaps.bitmapToByteArray(compressedBitmap), compressedFile)

            // 展示结果
            showCompressInfo(bitmap, compressedBitmap, compressedFile)
            mHandler.postDelayed({
                binding.ivPic.setImageBitmap(compressedBitmap) // 5s 后展示压缩过的图片
            }, 3000)
        }


        binding.btnRGB565Compress.setOnClickListener {
            log("从 assets 中加载图片并压缩：")

            //加载原始图片
            val rawBytes = assets.open("bitmap/pic.jpg").readBytes()
            val bitmap = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size)
            binding.ivPic.setImageBitmap(bitmap)

            // 压缩
            val compressedBitmap = Bitmaps.compressRGB565(rawBytes)

            //保存压缩的图片
            val compressedFile =
                File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "compressedImage.jpg")

            val baos = ByteArrayOutputStream()
            compressedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val compressedBytes = baos.toByteArray()
            FileUtils.writeToFile(compressedBytes, compressedFile)

            // 展示结果
            showCompressInfo(bitmap, compressedBitmap, compressedFile)
            mHandler.postDelayed({
                binding.ivPic.setImageBitmap(compressedBitmap) // 5s 后展示压缩过的图片
            }, 3000)
        }


        //加载超清大图
//        btnBigPic.setOnClickListener { startActivity(Intent(this, BigPicActivity::class.java)) }
    }


    private fun savePicToDisk() {
        val bytes = assets.open("bitmap/pic.jpg").readBytes()
        log("assets 中读取的大小 ： ${bytes.size / 1024} kb")

        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)//压缩图片并将数据存储到 baos 中

        val file = File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "pic.jpg")
        if (!file.exists()) {
            file.createNewFile()
        }
        val fileOutputStream = FileOutputStream(file)
        fileOutputStream.write(baos.toByteArray())

        log("保存到本地的图片大小 ${file.readBytes().size / 1024} kb")
        FileUtils.writeToFile(bytes, file)
    }

    @SuppressLint("SetTextI18n")
    private fun showInfo(bitmap: Bitmap) {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)

        val bitmapInfo = "图像宽高 ： ${bitmap.width} * ${bitmap.height} \n" +
                "图片格式： ${bitmap.config.name}\n" +
                "占用内存大小： ${Bitmaps.getMemorySize(bitmap)} kb \n" +
                "计算占用内存大小： ${Bitmaps.calculateMemorySize(bitmap)} kb \n" +
                "bitmap.density : ${bitmap.density} \n" +
                "屏幕的density : ${resources.displayMetrics.densityDpi} \n" +
                "Bitmap转换成文件大小 ：${baos.toByteArray().size / 1024} bk"

        binding.tvInfo.text = bitmapInfo
        log(bitmapInfo)
        baos.close()
    }

    @SuppressLint("SetTextI18n")
    private fun showCompressInfo( rawBitmap: Bitmap, compressedBitmap: Bitmap,  compressedFile: File ) {
        val rawBaos = ByteArrayOutputStream()
        rawBitmap.compress(Bitmap.CompressFormat.JPEG, 100, rawBaos)

        val compressedFileSize = FileUtils.fileSize(compressedFile)

        val bitmapInfo = "压缩前图像宽高 ： ${rawBitmap.width} * ${rawBitmap.height} \n" +
                "图片格式： ${rawBitmap.config.name}\n" +
                "占用内存大小： ${Bitmaps.getMemorySize(rawBitmap)} kb \n" +
                "计算占用内存大小： ${Bitmaps.calculateMemorySize(rawBitmap)} kb \n" +
                "bitmap.density : ${rawBitmap.density} \n" +
                "文件大小: ${rawBaos.toByteArray().size / 1024} kb \n" +
                "\n" +
                "压缩后图像宽高 ： ${compressedBitmap.width} * ${compressedBitmap.height} \n" +
                "图片格式： ${compressedBitmap.config.name}\n" +
                "占用内存大小： ${Bitmaps.getMemorySize(compressedBitmap)} kb \n" +
                "计算占用内存大小： ${Bitmaps.calculateMemorySize(compressedBitmap)} kb \n" +
                "bitmap.density : ${compressedBitmap.density} \n" +
                "文件大小: $compressedFileSize kb "

        binding.tvInfo.text = bitmapInfo
        log(bitmapInfo)
        rawBaos.close()
    }


}