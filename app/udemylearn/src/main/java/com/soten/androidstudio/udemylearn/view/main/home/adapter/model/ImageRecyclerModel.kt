package com.soten.androidstudio.udemylearn.view.main.home.adapter.model

import com.soten.androidstudio.udemylearn.data.ImageData

interface ImageRecyclerModel {

    fun addItem(imageData: ImageData)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}