package com.soten.androidstudio.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class Listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listner)

        val helloText = findViewById<TextView>(R.id.hello)

        // (1), (2), (3) 기능을 동일 람다방식이 가장 최근

        // (1) 람다 표현식
        helloText.setOnClickListener {
            Log.d("click", "Click!")
        }

        // (2) 익명 함수 방법
        helloText.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "Click!")
            }
        })

        // (3) -> 이름이 필요한 경우(click)
        val click = object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "Click!")
            }
        }

        helloText.setOnClickListener(click)
    }

}