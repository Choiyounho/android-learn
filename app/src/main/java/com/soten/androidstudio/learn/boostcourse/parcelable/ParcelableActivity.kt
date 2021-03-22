package com.soten.androidstudio.learn.boostcourse.parcelable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.soten.androidstudio.learn.R

class ParcelableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        findViewById<Button>(R.id.btn_parcelable).setOnClickListener {
            val intent = Intent(applicationContext, ParcelableMenuActivity::class.java)

            val names = ArrayList<String>()
            names.add("CYH")
            names.add("LHG")
            intent.putExtra("names", names)

            val data = SimpleData(100, "Hello")
            intent.putExtra("data", data)

            startActivityForResult(intent, 101)
        }
    }
}