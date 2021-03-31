package com.soten.androidstudio.learn.boostcourse.volley

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.soten.androidstudio.learn.R

class VolleyActivity : AppCompatActivity() {

    private val button: Button by lazy {
        findViewById(R.id.button3)
    }

    private val textView: TextView by lazy {
        findViewById(R.id.tv_volley)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)
        button.setOnClickListener {
            Log.d("test", "error")
            sendRequest()
        }

        if (AppHelper.requestQueue == null) {
            AppHelper.requestQueue = Volley.newRequestQueue(applicationContext)
        }
    }

    private fun sendRequest() {
        val url = "https://www.google.com/"

        val request = object : StringRequest(
            Method.GET,
            url,
            Response.Listener { response -> print("응답 $response") },
            Response.ErrorListener { error -> print("error $error") }) {
            override fun getParams(): MutableMap<String, String> {
                return HashMap()
            }
        }

        request.setShouldCache(false)
        AppHelper.requestQueue?.add(request)
        print("요청 보냄.")
    }


    private fun print(data: String) {
        textView.append("$data\n").toString()
    }
}