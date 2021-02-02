package com.soten.androidstudio.udemylearn.view.main.home.adapter.holder


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soten.androidstudio.udemylearn.R
import com.soten.androidstudio.udemylearn.data.ImageData
import com.soten.androidstudio.udemylearn.data.Photo
import kotlinx.android.synthetic.main.item_image_view.view.*

class ImageViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false)
) {

    fun onBind(item: Photo) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: Photo) {
        img_view.loadImage(item.getImageUrl())
    }
}