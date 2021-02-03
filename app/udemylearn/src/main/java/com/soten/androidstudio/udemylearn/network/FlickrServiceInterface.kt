package com.soten.androidstudio.udemylearn.network

import com.soten.androidstudio.udemylearn.BuildConfig
import com.soten.androidstudio.udemylearn.data.PhotoInfo
import com.soten.androidstudio.udemylearn.data.PhotoResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface FlickrServiceInterface {

    @POST("?method=flickr.photos.getRecent&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrSearchPhotos(
        @Query("text") keyword: String,
        @Query("safe_search") safeSearch: Int = 1,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<PhotoResponse>

    @POST("?method=flickr.photos.getInfo&api_key=${BuildConfig.FLICKR_API_KEY}&format=json&nojsoncallback=1")
    fun getFlickrPhotoDetail(
        @Query("photo_id") photoId: String
    ): Call<PhotoInfo>

}

