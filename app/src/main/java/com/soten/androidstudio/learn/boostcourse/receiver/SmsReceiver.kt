package com.soten.androidstudio.learn.boostcourse.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val toast = Toast.makeText(context, "good", Toast.LENGTH_LONG)
        toast.show()
        Log.d("breceiver", "전송완료")
    }
}