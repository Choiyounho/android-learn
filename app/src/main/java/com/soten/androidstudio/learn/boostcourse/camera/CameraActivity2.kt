package com.soten.androidstudio.learn.boostcourse.camera

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R

class CameraActivity2 : AppCompatActivity() {

    private val imageView: ImageView by lazy {
        findViewById(R.id.imageView)
    }

    lateinit var surfaceView: CameraSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)

        surfaceView = findViewById(R.id.surfaceView)
        findViewById<Button>(R.id.btn_picture).setOnClickListener {
            capture(surfaceView)
        }
    }

    private fun capture(surfaceView: CameraSurfaceView) {
        surfaceView.capture { data, camera ->
            val options = BitmapFactory.Options()
            options.inSampleSize = 8
            val bitmap = BitmapFactory.decodeByteArray(data, 0, data.size)

            imageView.setImageBitmap(bitmap)

            camera.startPreview()
        }
    }

}