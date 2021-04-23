package com.tuyrt.uieffect.module.extend.floats

import android.os.Bundle
import com.permissionutil.AdapterPermissionListener
import com.permissionutil.Permission
import com.permissionutil.PermissionImpl
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.arch.BaseActivity
import com.tuyrt.uieffect.arch.NoViewModel
import com.tuyrt.uieffect.databinding.ActivityFloatsMainBinding
import com.tuyrt.uieffect.module.extend.floats.floatwindow.FloatWindowService

/**
 * Created by tuyrt7 on 2021/4/23.
 * 悬浮窗
 */
class FloatsMainActivity:BaseActivity<NoViewModel,ActivityFloatsMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_floats_main

    override fun initView(savedInstanceState: Bundle?) {
        binding.btnFloatStart.setOnClickListener {
            PermissionImpl.init(this)
                .permission(Permission.SYSTEM_ALERT_WINDOW)
                .requestPermission(object :AdapterPermissionListener(){
                    override fun onGranted() {
                        FloatWindowService.start(this@FloatsMainActivity)
                    }
                })
        }

        binding.btnFloatStop.setOnClickListener {
            FloatWindowService.stop(this@FloatsMainActivity)
        }
    }
}