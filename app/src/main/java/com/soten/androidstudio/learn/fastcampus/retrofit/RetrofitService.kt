package com.soten.androidstudio.learn.fastcampus.retrofit

import com.soten.androidstudio.learn.fastcampus.PersonFromServer
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {

    @GET(value = "json/students")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST(value = "json/students")
    fun createStudent(@Body params: HashMap<String, Any>): Call<PersonFromServer>

    @POST(value = "json/students/")
    fun createStudentEasy(@Body person : PersonFromServer) : Call<PersonFromServer>
}