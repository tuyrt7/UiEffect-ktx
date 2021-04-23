package com.tuyrt.uieffect.module.extend.material

import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tuyrt.uieffect.R

/**
 * CoordinatorLayout + FollowBehavior
 */
class CoordinatorFollowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_follow)

        findViewById<Button>(R.id.btnObservable).setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_MOVE) {
                v.x = event.rawX - v.width / 2
                v.y = event.rawY - v.height / 2
            }
            true
        }
    }
}