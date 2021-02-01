package com.soten.androidstudio.learn.fastcampus.retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.fastcampus.PersonFromServer
import com.soten.androidstudio.learn.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        // GET
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("retrofitt", "res : ${personList?.get(0)?.age}")

                    val code = response.code()
                    Log.d("retrofitt", "code : $code" )
                }
            }

            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "fail")
            }
        })

        // POST(1)
//        val params = HashMap<String, Any>()
//        params["name"] = "김개똥"
//        params["age"] = 20
//        params["intro"] = "안녕하세요"
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer> {
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//            }
//
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("cannnn", "name : " + person?.name)
//                }
//
//            }
//        })


        // POST(2)
        val person = PersonFromServer(name = "창현이형 맞춤법 좀 제발", age = 1, intro = "잘 맞춰줘")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer> {
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("cannnn", "name : " + person?.name)
                }

            }
        })
    }
}