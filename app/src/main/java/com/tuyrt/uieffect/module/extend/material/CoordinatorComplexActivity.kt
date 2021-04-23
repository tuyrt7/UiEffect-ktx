package com.tuyrt.uieffect.module.extend.material

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.tabs.TabLayout
import com.tuyrt.uieffect.R

/**
 * 复杂布局
 * CoordinatorLayout + AppBar + CollapsingToolbarLayout + Toolbar + ImageView + TabLayout +FloatButton
 *
 * app:contentScrim：指定CollapsingToolbarLayout折叠后的Toolbar颜色
 * app:collapsedTitleTextAppearance：折叠状态标题文字的样式
 * app:expandedTitleTextAppearance：展开状态标题文字的样式
 */
class CoordinatorComplexActivity : AppCompatActivity() {

    private val webView: WebView by lazy {
        findViewById<WebView>(R.id.webView)
    }

    private val tabLayout: TabLayout by lazy {
        findViewById<TabLayout>(R.id.tabLayout)
    }

    private val toolbar: Toolbar by lazy {
        findViewById<Toolbar>(R.id.toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_complex)

        toolbar.setNavigationOnClickListener { finish() }

        webView.loadUrl("https://wanandroid.com/")

        tabLayout.addTab(tabLayout.newTab().setText("专辑"))
        tabLayout.addTab(tabLayout.newTab().setText("音乐"))
        tabLayout.addTab(tabLayout.newTab().setText("喜欢"))
    }
}