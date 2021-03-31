package com.soten.androidstudio.learn.boostcourse.server

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.soten.androidstudio.learn.R
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import java.net.ServerSocket

class ServerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server)

        val serverBtn = findViewById<Button>(R.id.btn_server)

        serverBtn.setOnClickListener {
            val intent = Intent(applicationContext, ChatService::class.java)
            startService(intent)
        }
    }




}

