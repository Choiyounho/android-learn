package com.soten.androidstudio.learn.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.soten.androidstudio.learn.R

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)

        val back: ImageView = findViewById(R.id.back)
        
        back.setOnClickListener {
            onBackPressed()
        }

        getPersonInfoAndDraw()
    }

    fun getPersonInfoAndDraw() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        val detailName: TextView = findViewById(R.id.detail_name)
        val detailNumber: TextView = findViewById(R.id.detail_number)

        detailName.text = name
        detailNumber.text = number
    }
}