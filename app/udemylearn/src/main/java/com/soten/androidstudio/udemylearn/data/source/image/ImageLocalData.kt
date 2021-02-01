package com.soten.androidstudio.udemylearn.data.source.image

import com.soten.androidstudio.udemylearn.util.random

class ImageLocalData : ImageDataSource {

    override fun loadImageFileName(fileName: (String) -> Unit) {
        fileName(String.format("sample_%02d", (1..10).random()))
    }

}