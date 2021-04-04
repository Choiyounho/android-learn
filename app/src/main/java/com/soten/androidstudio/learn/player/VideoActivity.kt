package com.soten.androidstudio.learn.player

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.soten.androidstudio.learn.R

class VideoActivity : AppCompatActivity() {

    private var url = "https"

    private val videoView: VideoView by lazy {
        findViewById(R.id.video_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val controller = MediaController(this)
        videoView.setMediaController(controller)
        videoView.setVideoURI(Uri.parse(url))
        videoView.requestFocus()

        videoView.setOnPreparedListener {
            Toast.makeText(applicationContext, "동영상 준비 됨", Toast.LENGTH_SHORT).show()
        }

        val btn = findViewById<Button>(R.id.btn_video)
        btn.setOnClickListener {
            videoView.seekTo(0)
            videoView.start()
        }

    }
}