package com.soten.androidstudio.learn.fastcampus.instagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.soten.androidstudio.learn.R
import kotlinx.android.synthetic.main.activity_email_sign_up.*

class EmailSignUpActivity : AppCompatActivity() {

    lateinit var userName: EditText
    lateinit var userPassword: EditText
    lateinit var userPasswordConfirm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_sign_up)

        initView(this@EmailSignUpActivity)
    }

    private fun initView(activity: EmailSignUpActivity) {
        userName = activity.findViewById(R.id.input_id)
        userPassword = activity.findViewById(R.id.input_password)
        userPasswordConfirm = activity.findViewById(R.id.confirm_password)
    }

    fun getUserName(): String = userName.text.toString()

    fun getUserPassword(): String = userPassword.text.toString()

    fun getUserPasswordConfirm() : String = userPasswordConfirm.text.toString()
}