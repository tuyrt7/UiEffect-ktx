package com.tuyrt.uieffect.module.extends.material

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.tuyrt.uieffect.R

/**
 * CoordinatorLayout + AppBar
 */
class CoordinatorAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_appbar)

        findViewById<WebView>(R.id.webView).loadUrl("https://wanandroid.com/")
    }
}