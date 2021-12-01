package com.tuyrt.uieffect.module.extends.gray

import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseFragment
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.FragmentGrayBinding

/**
 * Created by tuyrt7 on 2021/11/30.
 * 说明：
 */
class GrayFragment :BaseFragment<NoViewModel,FragmentGrayBinding>() {

    override val layoutId: Int = R.layout.fragment_gray

    override fun initView(savedInstanceState: Bundle?) {

    }
}