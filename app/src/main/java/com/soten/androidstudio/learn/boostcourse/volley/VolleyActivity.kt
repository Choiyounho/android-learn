package com.soten.androidstudio.learn.boostcourse.volley

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.soten.androidstudio.learn.R

@Suppress("NAME_SHADOWING")
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
        val url =
            "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101"

        val request = object : StringRequest(
            Method.GET,
            url,
            Response.Listener { response ->
                print("응답 $response")
                processResponse(response)
            },
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

    private fun processResponse(response: String) {
        val gson = Gson()
        val movieList = gson.fromJson(response, MovieList::class.java)

        movieList.let { movieList ->
            val countMovie = movieList.boxOfficeResult.dailyBoxOfficeList.size
            print("박스 오피스 타입 : ${movieList.boxOfficeResult.boxofficeType}")
            print("응답받은 영화 개수 : $countMovie")
        }
    }
}