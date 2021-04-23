package com.tuyrt.uieffect.module.extend.material

import android.content.Intent
import android.os.Bundle
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityMaterialBinding

/**
 * Created by tuyrt7 on 2021/4/23.
 */
class MaterialActivity:BaseActivity<NoViewModel,ActivityMaterialBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_material

    override fun initView(savedInstanceState: Bundle?) {
        binding.btnCoordinatorLayout.setOnClickListener {
            startActivity(Intent(this, CoordinatorFollowActivity::class.java))
        }

        binding.btnCoordinatorLayout2.setOnClickListener {
            startActivity(Intent(this, CoordinatorAppBarActivity::class.java))
        }

        binding.btnCoordinatorLayout3.setOnClickListener {
            startActivity(Intent(this, CoordinatorTabLayoutActivity::class.java))
        }

        binding.btnCoordinatorLayout4.setOnClickListener {
            startActivity(Intent(this, CoordinatorComplexActivity::class.java))
        }

        binding.btnToolbar.setOnClickListener {
            startActivity(Intent(this, ToolBarActivity::class.java))
        }

        binding.btnZhihu.setOnClickListener {
            startActivity(Intent(this, ZhiHuActivity::class.java))
        }
    }
}