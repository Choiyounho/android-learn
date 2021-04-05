package com.soten.androidstudio.learn.boostcourse.animation

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.soten.androidstudio.learn.R
import java.lang.Exception

class AnimationActivity : AppCompatActivity() {

    private val imageView: ImageView by lazy {
        findViewById(R.id.imageView2)
    }

    val handler = Handler()

    private val list = ArrayList<Drawable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)


        val res = resources
        list.add(res.getDrawable(R.drawable.ic_apple))
        list.add(res.getDrawable(R.drawable.ic_facebook))
        list.add(res.getDrawable(R.drawable.ic_back))
        list.add(res.getDrawable(R.drawable.ic_instagram))
        list.add(res.getDrawable(R.drawable.ic_apple))

        val btn = findViewById<Button>(R.id.btn_ani)
        btn.setOnClickListener {
            val thread = AnimationThread()
            thread.start()
        }
    }

    inner class AnimationThread : Thread() {
        override fun run() {
            super.run()
            var index = 0
            for (i in 0 until 100) {
                val index = i % 5
                val drawable = list[index]

                handler.post {
                    imageView.setImageDrawable(drawable)
                }

                try {
                    sleep(1000L)
                } catch (e: Exception) {}
            }
        }
    }
}