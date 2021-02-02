package com.soten.androidstudio.udemylearn.data.source.flickr

import com.soten.androidstudio.udemylearn.data.PhotoResponse
import retrofit2.Call

interface FlickrDataSource {

    fun getRecentPhoto(page: Int, perPage: Int): Call<PhotoResponse>

}