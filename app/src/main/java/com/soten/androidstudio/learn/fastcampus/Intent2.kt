package com.soten.androidstudio.learn.fastcampus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.soten.androidstudio.learn.R

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val result: Button = findViewById(R.id.result)

        result.setOnClickListener {
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number", "" + number1)
            Log.d("number", "" + number2)

            val result = number1 + number2

            val resultIntent = Intent()
            resultIntent.putExtra("result", result)

            setResult(RESULT_OK, resultIntent) // 결과 설정
            finish() // 액티비티 종료
        }
    }

}