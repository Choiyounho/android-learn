package com.soten.androidstudio.learn.fastcampus.retrofit

import com.soten.androidstudio.learn.fastcampus.PersonFromServer
import com.soten.androidstudio.learn.fastcampus.instagram.User
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET(value = "json/students")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST(value = "json/students")
    fun createStudent(@Body params: HashMap<String, Any>): Call<PersonFromServer>

    @POST(value = "json/students/")
    fun createStudentEasy(@Body person : PersonFromServer) : Call<PersonFromServer>

    @POST("user/signup/")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("password1") password: String,
        @Field("password2") passwordConfirm: String
    ): Call<User>

}