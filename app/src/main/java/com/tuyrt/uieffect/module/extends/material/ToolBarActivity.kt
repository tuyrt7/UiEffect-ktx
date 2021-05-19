package com.tuyrt.uieffect.module.extends.material

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.tuyrt.uieffect.R

/**
 */
class ToolBarActivity : AppCompatActivity() {

    private val toolBar: Toolbar by lazy {
        findViewById<Toolbar>(R.id.toolBar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        toolBar.inflateMenu(R.menu.menu_toolbar)
        toolBar.setOnMenuItemClickListener {
            Toast.makeText(this,"点击 menu -> ${it.title}",Toast.LENGTH_SHORT).show()
            return@setOnMenuItemClickListener true
        }
    }

}