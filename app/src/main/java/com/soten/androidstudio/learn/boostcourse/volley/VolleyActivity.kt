package com.soten.androidstudio.learn.boostcourse.volley

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.soten.androidstudio.learn.R
import com.soten.androidstudio.learn.boostcourse.volley.data.global.AppHelper
import com.soten.androidstudio.learn.boostcourse.volley.data.image.ImageLoadTask
import com.soten.androidstudio.learn.boostcourse.volley.data.movie.MovieList

class VolleyActivity : AppCompatActivity() {

    private val readBtn: Button by lazy {
        findViewById(R.id.btn_read)
    }

    private val imgBtn: Button by lazy {
        findViewById(R.id.btn_img_load)
    }

    private val textView: TextView by lazy {
        findViewById(R.id.tv_volley)
    }

    private val movieImg: ImageView by lazy {
        findViewById(R.id.img_movie)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley)

        readBtn.setOnClickListener {
            sendRequest()
        }

        imgBtn.setOnClickListener {
            sendImageRequest()
        }

        AppHelper.requestQueue = Volley.newRequestQueue(applicationContext)
    }

    private fun sendRequest() {
        val url =
            "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20210321"

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


    private fun processResponse(response: String) {
        val gson = Gson()
        val movieList = gson.fromJson(response, MovieList::class.java)

        movieList.let { movieList ->
            val countMovie = movieList.boxOfficeResult.dailyBoxOfficeList.size
            print("박스 오피스 타입 : ${movieList.boxOfficeResult.boxofficeType}")
            print("응답받은 영화 개수 : $countMovie")
        }
    }

    private fun sendImageRequest() {
        val url = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMjdfODYg%2FMDAxNjExNzMzNTkwNzE5.NXCulnOX98ypQd0sReYxFTX4w__NhMwXs2yMh_X4rRYg.wStQx6ZF8FaardIWYXygzV35l4QWPMiT3U192IB7r7sg.JPEG.lovevilbo%2F98f837ae15eb5f01629a9a6a4304302b.jpg&type=sc960_832"
        val task = ImageLoadTask(url, movieImg)
        task.execute()
    }

    private fun print(data: String) {
        textView.append("$data\n").toString()
    }
}