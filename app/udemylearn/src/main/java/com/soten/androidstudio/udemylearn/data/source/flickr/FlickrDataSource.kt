package com.soten.androidstudio.udemylearn.data.source.flickr

import com.soten.androidstudio.udemylearn.data.PhotoResponse
import retrofit2.Call

interface FlickrDataSource {

    fun getSearchPhoto(keyword: String, page: Int, perPage: Int): Call<PhotoResponse>

}