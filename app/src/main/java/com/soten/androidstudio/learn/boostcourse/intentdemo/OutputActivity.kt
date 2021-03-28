package com.soten.androidstudio.learn.boostcourse.intentdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import com.soten.androidstudio.learn.R

class OutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar_review)
        val button = findViewById<Button>(R.id.btn_write)

        button.setOnClickListener {
            showCommentWriteActivity(ratingBar)
        }
    }

    private fun showCommentWriteActivity(ratingBar: RatingBar) {
        val rating = ratingBar.rating

        val intent = Intent(applicationContext, InputActivity::class.java)
        intent.putExtra("rating", rating)
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 101) {
            val contents = data?.getStringExtra("contents")
            val outputView = findViewById<TextView>(R.id.tv_output_comment)
            outputView.text = contents
        }
    }

}
