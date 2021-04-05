package com.soten.androidstudio.learn.boostcourse.media.player

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.soten.androidstudio.learn.R

class AudioActivity : AppCompatActivity() {

    private val url = "/storage/emulated/0/Download/song.m4a"
    private var player: MediaPlayer? = MediaPlayer()
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        val start = findViewById<Button>(R.id.btn_play)
        start.setOnClickListener {
            playAudio()
        }

        val pause = findViewById<Button>(R.id.btn_pause)
        pause.setOnClickListener {
            pausePlayer()
        }

        val replay = findViewById<Button>(R.id.btn_replay)
        replay.setOnClickListener {
            replaying()
        }

        val stop = findViewById<Button>(R.id.btn_stop)
        stop.setOnClickListener {
            stopAudio()
        }
    }

    private fun playAudio() {
        killPlayer()
        player?.setDataSource(url)
        player?.prepare()
        player?.start()
        Toast.makeText(this, "재생", Toast.LENGTH_SHORT).show()
    }

    private fun pausePlayer() {
        player.let {
            position = player?.currentPosition!!
            player?.pause()
            Toast.makeText(this, "일시정지", Toast.LENGTH_SHORT).show()
        }
    }

    private fun replaying() {
        if (player != null && !player!!.isPlaying) {
            player?.seekTo(position)
            player?.start()

            Toast.makeText(this, "재시작", Toast.LENGTH_SHORT).show()
        }
    }

    private fun stopAudio() {
        player.let {
            if (player?.isPlaying!!) {
                player?.stop()

                Toast.makeText(this, "중지 됨", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun killPlayer() {
        player.let {
            player?.release()
            player = null
        }
    }
}