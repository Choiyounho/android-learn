package com.soten.androidstudio.learn.boostcourse.media.photo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.github.chrisbanes.photoview.PhotoView
import com.soten.androidstudio.learn.R

class PhotoActivity : AppCompatActivity() {

    private val editText: EditText by lazy {
        findViewById(R.id.et_youtube)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        val photoView = findViewById<PhotoView>(R.id.photoview)
        photoView.setImageResource(R.drawable.ic_apple)

        val btn = findViewById<Button>(R.id.btn_youtube)
        btn.setOnClickListener {
            val url = editText.text.toString()

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


    }
}