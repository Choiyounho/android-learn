package com.soten.androidstudio.learn.boostcourse.intentdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.soten.androidstudio.learn.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val menuBtn = findViewById<Button>(R.id.button2)
        menuBtn.setOnClickListener {
            val intent = Intent().putExtra("name", "younho")

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

}