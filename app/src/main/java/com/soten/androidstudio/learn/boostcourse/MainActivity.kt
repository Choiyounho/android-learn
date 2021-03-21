package com.soten.androidstudio.learn.boostcourse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.soten.androidstudio.learn.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(applicationContext, MenuActivity::class.java)
            startActivityForResult(intent, 101) // 메뉴액티비티를 띄울 때는 101이라는 코드를 요청한다.
        }
    }

    // 응답을 받아주는 메서드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //전송한 코드, 전송받은 코드, 데이터
        if (requestCode == 101) {
            val name = data?.getStringExtra("name")
            Toast.makeText(applicationContext, "메뉴화면으로부터의 응답 $name", Toast.LENGTH_SHORT).show()
        }
    }

}