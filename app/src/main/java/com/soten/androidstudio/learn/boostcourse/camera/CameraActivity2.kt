package com.soten.androidstudio.learn.boostcourse.camera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.soten.androidstudio.learn.R

class CameraActivity2 : AppCompatActivity() {

    private val imageView: ImageView by lazy {
        findViewById(R.id.imageView)
    }

    private val surfaceView: CameraSurfaceView by lazy {
        CameraSurfaceView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)

        findViewById<Button>(R.id.btn_picture).setOnClickListener {
            capture()
        }
    }

    private fun capture() {
        surfaceView.capture()
    }
}