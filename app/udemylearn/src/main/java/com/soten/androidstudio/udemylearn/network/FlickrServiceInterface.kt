package com.soten.androidstudio.udemylearn.network

import com.soten.androidstudio.udemylearn.BuildConfig
import com.soten.androidstudio.udemylearn.data.PhotoResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface FlickrServiceInterface {

    @POST("?method=flickr.photos.getRecent&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFLickrRecentPhotos(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<PhotoResponse>
}

