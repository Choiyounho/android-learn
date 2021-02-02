package com.soten.androidstudio.udemylearn.data.source.flickr

object FlickrRepository : FlickrDataSource {

    private val flickrRemoteData = FlickrRemoteData()

    override fun getSearchPhoto(keyword: String, page: Int, perPage: Int)
    = flickrRemoteData.getSearchPhoto(keyword, page, perPage)
}