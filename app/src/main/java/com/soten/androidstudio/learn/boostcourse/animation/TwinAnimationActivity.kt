package com.soten.androidstudio.learn.boostcourse.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
import com.google.android.material.animation.AnimationUtils
import com.soten.androidstudio.learn.R

class TwinAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twin_animation)

        val btn = findViewById<Button>(R.id.button3)
        btn.setOnClickListener {
            val scale: Animation = android.view.animation.AnimationUtils.loadAnimation(applicationContext, R.anim.scale)
            it.startAnimation(scale)
        }
    }
}