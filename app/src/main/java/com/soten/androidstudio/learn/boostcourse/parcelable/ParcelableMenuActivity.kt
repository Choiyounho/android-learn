package com.soten.androidstudio.learn.boostcourse.parcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.soten.androidstudio.learn.R
import kotlin.String as String

class ParcelableMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_menu)

        findViewById<Button>(R.id.btn_menu_parcelable).setOnClickListener {
            finish()
        }

        val passedIntent = intent
        processIntent(passedIntent)
    }

    private fun processIntent(passedIntent: Intent?) {
        passedIntent?.let {
            val names = it.getSerializableExtra("names") as ArrayList<String>
            names.let {
                Toast.makeText(applicationContext, "전달받은 개수 : ${names.size}", Toast.LENGTH_SHORT).show() }
        }

    }
}
