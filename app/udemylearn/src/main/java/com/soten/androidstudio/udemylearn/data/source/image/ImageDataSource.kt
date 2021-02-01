package com.soten.androidstudio.udemylearn.data.source.image

interface ImageDataSource {

    fun loadImageFileName(fileName: (String) -> Unit)
}