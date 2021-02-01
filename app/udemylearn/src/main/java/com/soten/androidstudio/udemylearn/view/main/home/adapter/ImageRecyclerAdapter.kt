package com.soten.androidstudio.udemylearn.view.main.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soten.androidstudio.udemylearn.data.ImageData
import com.soten.androidstudio.udemylearn.view.main.home.adapter.holder.ImageViewHolder
import com.soten.androidstudio.udemylearn.view.main.home.adapter.model.ImageRecyclerModel

class ImageRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel {

    private val list = mutableListOf<ImageData>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(parent)
    }

    override fun addItem(imageData: ImageData) {
        list.add(imageData)
    }

    override fun notifyDataSetChang() {
        notifyDataSetChanged()
    }
}