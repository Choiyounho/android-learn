package com.soten.androidstudio.udemylearn.data.source.image

object ImageRepository : ImageDataSource {

    private val imageLocalData: ImageLocalData by lazy {
        ImageLocalData()
    }

    override fun loadImageFileName(fileName: (String) -> Unit) {
        imageLocalData.loadImageFileName(fileName)
    }

}