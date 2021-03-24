package com.soten.androidstudio.learn.boostcourse.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action) {
            "android.provider.Telephony.SMS_RECEIVED" -> {
                Toast.makeText(context, "문자 받기", Toast.LENGTH_SHORT).show()
                Log.d("breceiver", "문자 받음")
            }
        }
    }

}