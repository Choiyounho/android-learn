package com.soten.androidstudio.udemylearn.data.source.image

object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int) {
        imageLocalData.loadImageList(imageDataList, size)
    }

}