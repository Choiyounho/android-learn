package com.soten.androidstudio.learn.boostcourse.receiver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R

class ReceiverMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_main)

        val br : BroadcastReceiver = SmsReceiver()
        val filter = IntentFilter().apply{
            addAction(Intent.ACTION_SCREEN_ON)
        }
        registerReceiver(br, filter)
    }
}