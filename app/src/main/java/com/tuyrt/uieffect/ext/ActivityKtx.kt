package com.tuyrt.uieffect.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by tuyrt7 on 2021/11/30.
 * 说明：
 */
fun FragmentActivity.addFragment(containerId: Int, frag: Fragment) {
    supportFragmentManager.beginTransaction()
        .add(containerId, frag)
        .commit()
}