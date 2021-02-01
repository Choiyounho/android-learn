package com.soten.androidstudio.udemylearn.data.source.image

import com.soten.androidstudio.udemylearn.data.ImageData

interface ImageDataSource {

    fun loadImageList(imageDataList: (List<ImageData>) -> Unit, size: Int)
}