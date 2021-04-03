package com.soten.androidstudio.learn.boostcourse.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.soten.androidstudio.learn.R

class ConnectActivity : AppCompatActivity() {

    val textView: TextView by lazy {
        findViewById(R.id.tv_network_status)
    }

    val button: Button by lazy {
        findViewById(R.id.btn_status_check)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)

        button.setOnClickListener {
            val status = NetworkStatus.getConnectivityStatus(applicationContext)
            if (status == NetworkStatus.TYPE_MOBILE) {
                textView.text = "모바일로 연결됨."
            } else if (status == NetworkStatus.TYPE_WIFI) {
                textView.text = "와이파이로 연결됨."
            } else {
                textView.text = "연결 안됨."
            }
        }
    }
}