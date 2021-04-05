package com.soten.androidstudio.learn.player

import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.soten.androidstudio.learn.R
import java.io.File
import java.lang.Exception

class RecorderActivity : AppCompatActivity() {

    private var mediaRecorder:  MediaRecorder? = null
    private var player: MediaPlayer? = MediaPlayer()

    private lateinit var filename: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recorder)

        val sdcard = Environment.getExternalStorageState()
        val file = File(sdcard, "recorded.mp4")
        filename = file.absolutePath
        Log.d("RecorderActivity", "파일명 : $filename")

        val recorder = findViewById<Button>(R.id.btn_recorder)
        recorder.setOnClickListener {
            recordAudio()
        }

        val pause = findViewById<Button>(R.id.btn_recorder_pause)
        pause.setOnClickListener {
            stopRecording()
        }

    }

    private fun recordAudio() {
        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT)

        mediaRecorder?.setOutputFile(filename)

        try {
            mediaRecorder?.prepare()
            mediaRecorder?.start()

            Toast.makeText(this, "녹음 시작 됨", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun stopRecording() {
        mediaRecorder.let {
            mediaRecorder?.stop()
            mediaRecorder?.release()
            mediaRecorder = null

            Toast.makeText(this, "녹음 중지 됨", Toast.LENGTH_SHORT).show()
        }
    }

    private fun killPlayer() {
        player.let {
            player?.release()
            player = null
        }
    }

}