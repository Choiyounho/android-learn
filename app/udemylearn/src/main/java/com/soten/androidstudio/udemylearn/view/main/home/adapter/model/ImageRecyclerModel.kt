package com.soten.androidstudio.udemylearn.view.main.home.adapter.model

import com.soten.androidstudio.udemylearn.data.Photo

interface ImageRecyclerModel {

    fun addItem(imageData: Photo)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}