package com.soten.androidstudio.udemylearn.data.source.image

interface ImageDataSource {

    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}