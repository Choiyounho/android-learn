package com.soten.androidstudio.learn.fastcampus.instagram

import android.app.Application
import android.content.Context
import android.util.Log
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.soten.androidstudio.learn.fastcampus.retrofit.RetrofitService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApplication : Application() { // Application()은 앱 전반의 설정을 할 때

    lateinit var service: RetrofitService

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this@MasterApplication)
        createRetrofit()

    }

    private fun createRetrofit() {
        val header = Interceptor {
            val original = it.request()
            if (checkIsLogin()) {
                getUserToken()?.let { token ->
                    val request = original.newBuilder()
                        .header("Authorization", token)
                        .build()
                    it.proceed(request)
                }

            } else {
                it.proceed(original)
            }
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://melowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(RetrofitService::class.java)
    }

    private fun checkIsLogin(): Boolean {
        val sharedPreferences = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("login_sp", "null")
        token?.let { return true } ?: return false
    }

    private fun getUserToken(): String? {
        val sharedPreferences = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("login_sp", "null")
        token?.let { return token } ?: return null
    }
}