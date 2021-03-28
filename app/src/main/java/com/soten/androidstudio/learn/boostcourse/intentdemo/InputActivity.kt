package com.soten.androidstudio.learn.boostcourse.intentdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import com.soten.androidstudio.learn.R

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar_comment)
        val contentsInput = findViewById<EditText>(R.id.et_contentsInput)

        val saveBtn = findViewById<Button>(R.id.btn_save)
        saveBtn.setOnClickListener {
            returnToMain(contentsInput)
        }

        val intent = intent
        processIntent(intent, ratingBar)
    }

    private fun processIntent(intent: Intent?, ratingBar: RatingBar) {
        intent?.let {
            val rating = intent.getFloatExtra("rating", 0.0f)
            ratingBar.rating = rating
        }

    }

    private fun returnToMain(contentsInput: EditText) {
        val intent = Intent()
        intent.putExtra("contents", contentsInput.text.toString())

        setResult(RESULT_OK, intent)
        finish()
    }
}