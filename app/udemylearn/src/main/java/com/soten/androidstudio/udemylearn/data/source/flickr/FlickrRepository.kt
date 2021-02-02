package com.soten.androidstudio.udemylearn.data.source.flickr

object FlickrRepository : FlickrDataSource {

    private val flickrRemoteData = FlickrRemoteData()

    override fun getRecentPhoto(page: Int, perPage: Int) = flickrRemoteData.getRecentPhoto(page, perPage)
}