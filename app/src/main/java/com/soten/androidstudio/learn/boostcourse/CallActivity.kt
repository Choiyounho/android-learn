package com.soten.androidstudio.learn.boostcourse

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.soten.androidstudio.learn.R

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        val editText = findViewById<EditText>(R.id.et_number)

        val numberBtn = findViewById<Button>(R.id.btn_number)
        numberBtn.setOnClickListener {
            val receiver = editText.text.toString()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$receiver"))

            startActivity(intent)

            val componentIntent = Intent()
            val componentName = ComponentName(
                "com.soten.androidstudio.learn.boostcourse",
                "com.soten.androidstudio.learn.boostcourse.MenuActivity"
            )
            componentIntent.component = componentName
            startActivity(componentIntent)
        }
    }
}