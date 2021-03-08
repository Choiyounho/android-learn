package com.soten.androidstudio.learn.fastcampus.youtobe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.soten.androidstudio.learn.R
import kotlinx.android.synthetic.main.activity_youtube_detail.*

class YoutubeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_detail)

        val url = intent.getStringExtra("video_url")

        val mediaController = MediaController(this@YoutubeDetailActivity)
        video_view.setVideoPath(url)
        video_view.requestFocus()
        video_view.start()
        mediaController.show()

    }
}