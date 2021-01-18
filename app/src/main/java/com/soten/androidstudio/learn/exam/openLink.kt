package com.soten.androidstudio.learn.exam

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.soten.androidstudio.learn.R

class onLink : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_link)



        val intent4 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
        startActivity(intent4)

        val editText: EditText = findViewById(R.id.edit_link)

        val linkButton: Button = findViewById(R.id.link_button)

        linkButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(editText.toString()))
            startActivity(intent)
        }
    }


}