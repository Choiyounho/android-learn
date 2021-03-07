package com.soten.androidstudio.learn.fastcampus.instagram

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.item_phonenumber.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login2.setOnClickListener {
            val username = username_inputbox1.text.toString()
            val password = password_inputbox.text.toString()
            (application as MasterApplication).service.login(
                username, password
            ).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        val user = response.body()
                        val token = user!!.token!!
                        saveUserToken(token, this@LoginActivity)
                        (application as MasterApplication).createRetrofit()
                        Toast.makeText(this@LoginActivity, "로그인 하셨습니다", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this@LoginActivity, InstagramPostListActivity::class.java))
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {

                }
            })
        }
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.apply()
    }
}