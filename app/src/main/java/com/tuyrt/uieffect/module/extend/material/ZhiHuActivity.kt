package com.tuyrt.uieffect.module.extend.material

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.tuyrt.uieffect.R

/**
 *  仿知乎标题栏
 */
class ZhiHuActivity : AppCompatActivity() {

    private val toolBar: Toolbar by lazy {
        findViewById<Toolbar>(R.id.toolBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_zhihu)

        toolBar.setNavigationOnClickListener {
            Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show()
        }
        toolBar.inflateMenu(R.menu.menu_zhihu)
        toolBar.setOnMenuItemClickListener {
            Toast.makeText(this,"点击 menu -> ${it.title}",Toast.LENGTH_SHORT).show()
            return@setOnMenuItemClickListener true
        }
    }
}