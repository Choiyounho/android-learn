package com.soten.androidstudio.learn.boostcourse.intentdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R
import com.soten.androidstudio.learn.boostcourse.service.MyService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(applicationContext, MenuActivity::class.java)
            startActivityForResult(intent, 101) // 메뉴액티비티를 띄울 때는 101이라는 코드를 요청한다.
        }

        val editText = findViewById<EditText>(R.id.et_service)
        val serviceBtn = findViewById<Button>(R.id.btn_service)
        serviceBtn.setOnClickListener {
            val name = editText.text.toString()

            val intent = Intent(applicationContext, MyService::class.java)
            intent.putExtra("command", "show")
            intent.putExtra("name", name)
            startService(intent)
        }

        val passedIntent = intent
        processCommand(passedIntent)
    }

    private fun processCommand(passedIntent: Intent?) {
        passedIntent.let {
            val command = intent.getStringExtra("command")
            val name = intent.getStringExtra("name")

            Toast.makeText(applicationContext, "서비스로부터의 응답 $command, $name", Toast.LENGTH_SHORT).show()
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

    override fun onNewIntent(intent: Intent?) {
        processCommand(intent)

        super.onNewIntent(intent)

    }

}