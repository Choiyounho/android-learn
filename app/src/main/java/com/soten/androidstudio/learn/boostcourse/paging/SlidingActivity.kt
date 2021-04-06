package com.soten.androidstudio.learn.boostcourse.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import com.soten.androidstudio.learn.R

class SlidingActivity : AppCompatActivity() {

    private val page: LinearLayout by lazy {
        findViewById(R.id.page)
    }

    private val btn: Button by lazy {
        findViewById(R.id.btn_left)
    }


    var isPageOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding)



        val translateLeft: Animation = AnimationUtils.loadAnimation(this, R.anim.translate_left)
        val translateRight: Animation = AnimationUtils.loadAnimation(this, R.anim.translate_right)

        val listener = SlidingAnimationListener()
        translateLeft.setAnimationListener(listener)
        translateRight.setAnimationListener(listener)

        btn.setOnClickListener {
            if (isPageOpen) {
                page.startAnimation(translateRight)
            } else {
                page.visibility = View.VISIBLE
                page.startAnimation(translateLeft)
            }
        }
    }

    inner class SlidingAnimationListener : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {
            if (isPageOpen) {
                page.visibility = View.INVISIBLE

                btn.text = "열기"
                isPageOpen = false
            } else {
                btn.text = "닫기"
                isPageOpen = true

            }
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

    }
}