package com.tuyrt.uieffect.module.tools.asyncinflate

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tuyrt.uieffect.R
import com.tuyrt.uieffect.utils.AsyncLayoutInflatePlus

/**
 * Created by tuyrt7 on 2021/12/1.
 * 说明：
 * 原理：https://www.jianshu.com/p/8548db25a475
 */
class AsyncInflateActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val start = System.currentTimeMillis()
        AsyncLayoutInflatePlus(this).inflate(R.layout.activity_async_inflate,null) { view, _, _ ->
            setContentView(view)

            val tv = view.findViewById<TextView>(R.id.tv_inflate)
            tv.text = "异步加载布局 ++ \n 耗时：${System.currentTimeMillis() - start}"
        }
    }
}