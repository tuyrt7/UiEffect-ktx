package com.tuyrt.uieffect.module.extends.mark

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityMarkBinding

/**
 * Created by tuyrt7 on 2021/4/22.
 * ่กจๆๆๆ
 */
class MarkActivity : BaseActivity<NoViewModel, ActivityMarkBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_mark

    override fun initView(savedInstanceState: Bundle?) {
       binding.recyclerView.apply {
           layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
           adapter = MarkAdapter(context)
       }
    }

}