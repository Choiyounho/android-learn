package com.soten.androidstudio.learn.fastcampus

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.soten.androidstudio.learn.R

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val change: Button = findViewById(R.id.change_activity)

        change.setOnClickListener {
            // 인텐트 사용법 Intent(자기자신, 대상)
//            val intent = Intent(this@Intent1, Intent2::class.java)

            // Key, Value 방식
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            startActivity(intent)

//            val intent2 = Intent(this@Intent1, Intent2::class.java)
//            // 위의 코드와 동일, 가독성이 좋다
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
//            startActivityForResult(intent2, 200)

            // 암시적 인텐트 Intent(할 행동, )
           val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
           startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 200) {
            Log.d("number", "" + requestCode)
            Log.d("number", "" + resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number", "" + result)

        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}