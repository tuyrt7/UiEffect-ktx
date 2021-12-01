package com.tuyrt.uieffect.module.components.button

import android.os.Bundle
import android.widget.Toast
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityButtonMainBinding
import com.tuyrt.uieffect.view.button.loading.LoadingButton

/**
 * Created by tuyrt7 on 2021/11/30.
 * 说明：
 */
class ButtonActivity : BaseActivity<NoViewModel, ActivityButtonMainBinding>() {

    private val loadingBtn by lazy { binding.loadingBtn }

    override val layoutId: Int = R.layout.activity_button_main

    override fun initView(savedInstanceState: Bundle?) {
        initLoadingButton()
    }

    private fun initLoadingButton() {
        loadingBtn.setOnClickListener {
            loadingBtn.start()
            loadingBtn.postDelayed({ loadingBtn.complete() }, 3000)
        }
        loadingBtn.cancel()
        //loadingBtn.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        loadingBtn //.setEnableShrink(true)
            //.setDisableClickOnLoading(true)
            //.setLoadingColor(loadingBtn.getTextColors().getDefaultColor())
            ////.setLoadingStrokeWidth((int) (loadingBtn.getTextSize() * 0.14f))
            .setOnLoadingListener(object : LoadingButton.OnLoadingListenerAdapter() {
                override fun onCompleted() {
                    toast("go go go")
                }
            })
    }
}