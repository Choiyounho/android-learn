package com.soten.androidstudio.learn.fastcampus.instagram

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.soten.androidstudio.learn.R
import kotlinx.android.synthetic.main.activity_instagram_post_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InstagramPostListActivity : AppCompatActivity() {

    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_post_list)

        glide = Glide.with(this)

        (application as MasterApplication).service.getAllPosts().enqueue(
            object : Callback<ArrayList<Post>> {
                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    if (response.isSuccessful) {
                        val postList = response.body()
                        val adapter = PostAdapter(
                            postList!!,
                            LayoutInflater.from(this@InstagramPostListActivity),
                            glide
                        )
                        post_recyclerview.adapter = adapter
                        post_recyclerview.layoutManager =
                            LinearLayoutManager(this@InstagramPostListActivity)
                    }
                }

                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                }
            }
        )

        info.setOnClickListener {
            startActivity(
                Intent(this, InstagramUserInfoActivity::class.java)) }
        my_list.setOnClickListener {
            startActivity(
                Intent(this, InstagramMyPostActivity::class.java)) }
        upload.setOnClickListener {
            startActivity(
                Intent(this, InstagramUploadActivity::class.java)) }
    }

    class PostAdapter(
        private val postList: ArrayList<Post>,
        val inflater: LayoutInflater,
        private val glide: RequestManager
    ) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val postOwner: TextView = itemView.findViewById(R.id.post_owner)
            val postImage: ImageView = itemView.findViewById(R.id.post_img)
            val postContent: TextView = itemView.findViewById(R.id.post_content)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.instagram_item_view, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.postOwner.text = postList[position].owner
            holder.postContent.text = postList[position].content
            glide.load(postList[position].image).into(holder.postImage)
        }

        override fun getItemCount(): Int = postList.size
    }

}