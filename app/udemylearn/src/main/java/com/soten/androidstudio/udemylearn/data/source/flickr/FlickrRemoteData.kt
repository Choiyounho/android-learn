package com.soten.androidstudio.udemylearn.data.source.flickr

import com.soten.androidstudio.udemylearn.network.FlickrServiceInterface
import com.soten.androidstudio.udemylearn.network.createRetrofit

class FlickrRemoteData : FlickrDataSource {

    companion object {
        const val FLICKR_URL = "https://www.flickr.com/services/rest/"
    }

    private val flickrServiceInterface =
        createRetrofit(FlickrServiceInterface::class.java, FLICKR_URL)

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
            = flickrServiceInterface.getFlickrSearchPhotos(
        keyword = keyword,
        page = page,
        perPage = perPage)
}