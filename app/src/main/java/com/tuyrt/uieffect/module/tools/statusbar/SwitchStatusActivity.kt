package com.tuyrt.uieffect.module.tools.statusbar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.tuyrt.uieffect.R


/**
 * Created by tuyrt7 on 2021/7/28.
 */
class SwitchStatusActivity : AppCompatActivity(), View.OnClickListener {

    private var mRLayout: RelativeLayout? = null
    private var mBtn1: Button? =null
    private  var mBtn2:Button? = null
    private  var mBtn3:Button? = null
    private  var mBtn4:Button? = null
    private  var mBtn5:Button? = null
    private  var mBtn6:Button? = null
    private  var mBtn7:Button? = null
    private  var mBtn8:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_switch)
        mRLayout = findViewById<View>(R.id.content) as RelativeLayout
        mBtn1 = findViewById<View>(R.id.btn1) as Button
        mBtn2 = findViewById<View>(R.id.btn2) as Button
        mBtn3 = findViewById<View>(R.id.btn3) as Button
        mBtn4 = findViewById<View>(R.id.btn4) as Button
        mBtn5 = findViewById<View>(R.id.btn5) as Button
        mBtn6 = findViewById<View>(R.id.btn6) as Button
        mBtn7 = findViewById<View>(R.id.btn7) as Button
        mBtn8 = findViewById<View>(R.id.btn8) as Button
        mBtn1!!.setOnClickListener(this)
        mBtn2!!.setOnClickListener(this)
        mBtn3!!.setOnClickListener(this)
        mBtn4!!.setOnClickListener(this)
        mBtn5!!.setOnClickListener(this)
        mBtn6!!.setOnClickListener(this)
        mBtn7!!.setOnClickListener(this)
        mBtn8!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 ->             //显示状态栏，Activity不全屏显示(恢复到有状态的正常情况)
                mRLayout!!.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            R.id.btn2 ->             //隐藏状态栏，同时Activity会伸展全屏显示
                mRLayout!!.systemUiVisibility = View.INVISIBLE
            R.id.btn3 ->             //Activity全屏显示，且状态栏被隐藏覆盖掉。
                mRLayout!!.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            R.id.btn4 ->             //Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态遮住
                mRLayout!!.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            R.id.btn5 ->             //同mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                mRLayout!!.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            R.id.btn6 ->             //同mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                mRLayout!!.systemUiVisibility = View.SYSTEM_UI_LAYOUT_FLAGS
            R.id.btn7 ->             //隐藏虚拟按键(导航栏)
                mRLayout!!.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            R.id.btn8 ->             //状态栏显示处于低能显示状态(low profile模式)，状态栏上一些图标显示会被隐藏。
                mRLayout!!.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
        }
    }
}