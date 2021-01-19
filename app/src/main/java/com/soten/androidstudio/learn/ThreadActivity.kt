package com.soten.androidstudio.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val runnable: Runnable = Runnable {
            Log.d("thread-1", "Thread is made")
        }
        val thread: Thread = Thread(runnable)

        val button: Button = findViewById(R.id.button_thread)

        Log.d("thread-1", "Thread2 is made")
        button.setOnClickListener {
            thread.start()
            Log.d("thread-1", "Thread3 is made")
            Thread.sleep(2000)
            Log.d("thread-1", "Thread4 is made")
            button.setBackgroundColor(getColor(R.color.black))
            Thread.sleep(2000)
            Log.d("thread-1", "button color change")
        }
    }
}