package com.soten.androidstudio.udemylearn.data.source.image

import com.soten.androidstudio.udemylearn.data.ImageData

object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageRemoteData by lazy {
        ImageRemoteData()
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        imageLocalData.loadImageList(imageDataList, size)
    }

}