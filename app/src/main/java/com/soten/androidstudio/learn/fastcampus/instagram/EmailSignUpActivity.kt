package com.soten.androidstudio.learn.fastcampus.instagram

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R
import kotlinx.android.synthetic.main.activity_email_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailSignUpActivity : AppCompatActivity() {

    lateinit var userName: EditText
    lateinit var userPassword: EditText
    lateinit var userPasswordConfirm: EditText
    lateinit var registerButton: Button
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_sign_up)

        initView(this@EmailSignUpActivity)
        setUpListener(this)

    }

    private fun initView(activity: EmailSignUpActivity) {
        userName = activity.findViewById(R.id.input_id)
        userPassword = activity.findViewById(R.id.input_password)
        userPasswordConfirm = activity.findViewById(R.id.confirm_password)
        registerButton = activity.findViewById(R.id.btn_register)
        loginButton = activity.findViewById(R.id.btn_login)
    }

    private fun setUpListener(activity: Activity) {
        registerButton.setOnClickListener {
            register(this@EmailSignUpActivity)
        }
        loginButton.setOnClickListener {
            val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
            val token = sp.getString("login_sp", "")
            Log.d("test", "$token")
        }
    }

    private fun register(activity: Activity) {
        val username = getUserName()
        val password = getUserPassword()
        val passwordConfirm = getUserPasswordConfirm()

        (application as MasterApplication).service.register(username, password, passwordConfirm)
            .enqueue(object :
                Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Toast.makeText(activity, "가입에 성공했습니다", Toast.LENGTH_LONG).show()
                        val user = response.body()
                        val token = user!!.token!!
                        saveUserToken(token, activity)
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(activity, "가입에 실패했습니다", Toast.LENGTH_LONG).show()
                }
            })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = activity.getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("login_sp", token)
        editor.apply()
    }

    fun getUserName(): String = userName.text.toString()

    fun getUserPassword(): String = userPassword.text.toString()

    fun getUserPasswordConfirm(): String = userPasswordConfirm.text.toString()
}