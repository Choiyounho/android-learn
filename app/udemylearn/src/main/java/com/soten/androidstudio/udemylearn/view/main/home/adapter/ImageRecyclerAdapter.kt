package com.soten.androidstudio.udemylearn.view.main.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soten.androidstudio.udemylearn.data.ImageData
import com.soten.androidstudio.udemylearn.data.Photo
import com.soten.androidstudio.udemylearn.view.main.home.adapter.holder.ImageViewHolder
import com.soten.androidstudio.udemylearn.view.main.home.adapter.model.ImageRecyclerModel

class ImageRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ImageRecyclerModel {

    private val list = mutableListOf<Photo>()

    override lateinit var onClick: (Int) -> Unit

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(onClick, parent)
    }

    override fun addItem(imageData: Photo) {
        list.add(imageData)
    }

    override fun getItem(position: Int): Photo {
        return list[position]
    }

    override fun notifyDataSetChang() {
        notifyDataSetChanged()
    }
}