package com.soten.androidstudio.learn.boostcourse.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.soten.androidstudio.learn.boostcourse.intentdemo.MainActivity

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("mservice", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("mservice", "onDestroy")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("mservice", "onStartCommand")

        intent?.let {
            processCommand(intent)
        } ?: return Service.START_STICKY

        return super.onStartCommand(intent, flags, startId)
    }

    private fun processCommand(intent: Intent?) {
        val command = intent?.getStringExtra("command").toString()
        val name = intent?.getStringExtra("name").toString()

        Log.d("mservice", "전달받은 데이터 : $command, $name ")

        try {
            Thread.sleep(5000L)
        } catch (e: Exception) {
            Log.d("e", "Exception")
        }

        val showIntent = Intent(applicationContext, MainActivity::class.java)
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)

        showIntent.putExtra("command", "show")
        showIntent.putExtra("name", "$name from service.")

        startActivity(showIntent)
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}