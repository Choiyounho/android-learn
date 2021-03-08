package com.soten.androidstudio.learn.fastcampus.instagram

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R
import kotlinx.android.synthetic.main.activity_instagram_user_info.*

class InstagramUserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_user_info)

        all_list.setOnClickListener {
            startActivity(
                Intent(this, InstagramPostListActivity::class.java)
            ) }
        my_list.setOnClickListener {
            startActivity(
                Intent(this, InstagramMyPostActivity::class.java)
            ) }
        upload.setOnClickListener {
            startActivity(
                Intent(this, InstagramUploadActivity::class.java)
            ) }

        logout.setOnClickListener {
            val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString("login_sp", "null")
            editor.apply()
            (application as MasterApplication).createRetrofit()
            finish()
            startActivity(Intent(this, LoginActivity::class.java ))
        }
    }
}