package com.soten.androidstudio.learn.boostcourse.media.photo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.chrisbanes.photoview.PhotoView
import com.soten.androidstudio.learn.R

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        val photoView = findViewById<PhotoView>(R.id.photoview)

        photoView.setImageResource(R.drawable.ic_apple)
    }
}