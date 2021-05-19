package com.tuyrt.uieffect.module.extends.material

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.tuyrt.uieffect.R

/**
 *  CoordinatorLayout + ImageView + TabLayout
 */
class CoordinatorTabLayoutActivity : AppCompatActivity() {
    private val webView: WebView by lazy {
        findViewById<WebView>(R.id.webView)
    }

    private val tabLayout: TabLayout by lazy {
        findViewById<TabLayout>(R.id.tabLayout)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_tablayout)

        webView.loadUrl("https://wanandroid.com/")

        tabLayout.addTab(tabLayout.newTab().setText("专辑"))
        tabLayout.addTab(tabLayout.newTab().setText("音乐"))
        tabLayout.addTab(tabLayout.newTab().setText("喜欢"))
    }
}