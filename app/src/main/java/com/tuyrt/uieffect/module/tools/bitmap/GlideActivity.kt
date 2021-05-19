package com.tuyrt.uieffect.module.tools.bitmap

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.FutureTarget
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityBitmapGlideBinding
import jp.wasabeef.glide.transformations.BlurTransformation

/**
 * Created by tuyrt7 on 2021/4/23.
 * glide 使用
 */
class GlideActivity : BaseActivity<NoViewModel, ActivityBitmapGlideBinding>() {

    private var IMAGE_URL =
        "http://dingyue.ws.126.net/S8bZlsJBtFYOf0xrTJfjPrpIPVtjL5MawSVqYPkey3KCd1548725430403compressflag.jpg"
    val IMAGE_URL2 = "http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg"
    var IMAGE_URL3 =
        "http://sjbz.fd.zol-img.com.cn/t_s1080x1920c/g5/M00/09/0C/ChMkJluJNc6IEocxAA242Pyd4qUAArXegMtSfoADbjw777.jpg"
    var IMAGE_URL4 = "https://www.baidu.com/img/bd_logo1.png"

    override val layoutId: Int
        get() = R.layout.activity_bitmap_glide

    override fun initView(savedInstanceState: Bundle?) {
        binding.btnLoadImage.setOnClickListener {

            val options = RequestOptions()
            options.placeholder(R.mipmap.ic_launcher)  //占位符
            options.error(R.drawable.ic_launcher_foreground)  //错误
            options.diskCacheStrategy(DiskCacheStrategy.NONE) //硬盘缓存
            options.skipMemoryCache(false)  //内存缓存
            options.override(Target.SIZE_ORIGINAL) //指定图片大小

            Glide.with(this)
                .asBitmap()
                .load(IMAGE_URL)
                .apply(options)
                .placeholder(R.mipmap.ic_launcher)
                .listener(object : RequestListener<Bitmap> {
                    override fun onResourceReady(
                        resource: Bitmap?, model: Any?, target: Target<Bitmap>?,
                        dataSource: DataSource?, isFirstResource: Boolean
                    ): Boolean {

                        binding.ivBig1.setImageBitmap(resource)
                        return true  //true表示已经处理，不再继续向下传递
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Bitmap>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return true
                    }
                })
                .transition(BitmapTransitionOptions.withCrossFade())
                .into(binding.ivBig1)
        }


        val simpleTarget = object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                binding.ivBig1.setImageDrawable(resource)
            }
        }

        //
        binding.btnSimpleTarget.setOnClickListener {
            Glide.with(this)
                .load(IMAGE_URL2)
                .into(simpleTarget)
        }

        //预加载
        binding.btnPreload.setOnClickListener {

            Glide.with(this)
                .load(IMAGE_URL)
                .preload()

            Thread.sleep(2000)

            Glide.with(this)
                .load(IMAGE_URL)
                .into(binding.ivBig1)
        }

        //仅下载图片
        binding.btnSubmit.setOnClickListener {

            Thread {
                val futureTarget: FutureTarget<Bitmap> = Glide.with(this)
                    .asBitmap()
                    .load(IMAGE_URL)
                    .submit()

                val file = futureTarget.get()

                runOnUiThread {
                    binding.ivBig1.setImageBitmap(file)
                    Toast.makeText(this, "图片下载成功~${file.width}", Toast.LENGTH_SHORT).show()
                }

            }.start()
        }

        //圆形图片
        binding.btnCircle.setOnClickListener {
            Glide.with(this)
                .load(IMAGE_URL)
                .circleCrop()
                .into(binding.ivBig1)

        }

        //图片模糊
        binding.btnBlur.setOnClickListener {
            Glide.with(this)
                .load(IMAGE_URL)
                .transform(BlurTransformation())
                //.transform(BlurTransformation(), GrayscaleTransformation())
                .into(binding.ivBig1)
        }

        //缩略图
        binding.btnThumbnail.setOnClickListener {
            Glide.with(this)
                .load(IMAGE_URL3)
                .thumbnail(0.25f)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.ivBig1)
        }
    }
}