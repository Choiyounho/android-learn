package com.soten.androidstudio.learn.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.soten.androidstudio.learn.R

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val glideImage: ImageView = findViewById(R.id.glide)

        Glide.with(this@LibraryActivity)
            .load("https://previews.123rf.com/images/4045qd/4045qd1608/4045qd160800044/61532164-%EA%B3%84%EB%A6%BC%EC%9D%98-%ED%92%8D%EA%B2%BD.jpg")
            .centerCrop()
            .into(glideImage)

    }
}