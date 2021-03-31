package com.soten.androidstudio.learn.fastcampus.retrofit

import com.soten.androidstudio.learn.fastcampus.PersonFromServer
import com.soten.androidstudio.learn.fastcampus.instagram.Post
import com.soten.androidstudio.learn.fastcampus.instagram.User
import com.soten.androidstudio.learn.fastcampus.melon.Song
import com.soten.androidstudio.learn.fastcampus.youtobe.Youtube
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET(value = "json/students")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST(value = "json/students")
    fun createStudent(@Body params: HashMap<String, Any>): Call<PersonFromServer>

    @POST(value = "json/students/")
    fun createStudentEasy(@Body person: PersonFromServer): Call<PersonFromServer>

    @POST("user/signup/")
    @FormUrlEncoded
    fun register(
        @Field("username") username: String,
        @Field("password1") password: String,
        @Field("password2") passwordConfirm: String
    ): Call<User>

    @POST("user/login/")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<User>

    @GET("instagram/post/list/all/")
    fun getAllPosts(): Call<ArrayList<Post>>

    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @Part image: MultipartBody.Part,
        @Part("content") requestBody: RequestBody
    ): Call<Post>

    @GET("instagram/post/list/")
    fun getUserPostList(): Call<ArrayList<Post>>

    @GET("youtube/list/")
    fun getYoutubeList(): Call<ArrayList<Youtube>>

    @GET("melon/list/")
    fun getSongList(): Call<ArrayList<Song>>
}