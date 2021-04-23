package com.tuyrt.uieffect.module.tool.bitmap

import android.os.Bundle
import com.davemorrissey.labs.subscaleview.ImageSource
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityBitmapSubsamplingBinding

/**
 * Created by tuyrt7 on 2021/4/23.
 * 使用加载超大图的库
 */
class SubSamplingActivity : BaseActivity<NoViewModel, ActivityBitmapSubsamplingBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_bitmap_subsampling

    override fun initView(savedInstanceState: Bundle?) {
//        ivSubSamplingView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CENTER_CROP) //设置缩放类型
//        ivSubSamplingView.setDoubleTapZoomScale(1f)
        binding.ivSubSamplingView.setImage(ImageSource.asset("bitmap/qmsht.jpg"))

        //设置预览图
        //注意，目标图的大小必须先声明
//        ivSubSamplingView.setImage(
//                ImageSource.asset("qmsht.jpg").dimensions(30000, 926),
//                ImageSource.asset("pic2.jgp"))
    }

}