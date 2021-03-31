package com.soten.androidstudio.learn.fastcampus.instagram

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R
import kotlinx.android.synthetic.main.activity_instagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class InstagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_upload)

        view_pictures.setOnClickListener {
            Log.d("patht", "클릭")
            getPicture()
        }

        img_upload.setOnClickListener {
            Log.d("patht", "시작")
            uploadPost()
        }

        all_list.setOnClickListener {
            startActivity(
                Intent(this, InstagramPostListActivity::class.java)
            )
        }
        info.setOnClickListener {
            startActivity(
                Intent(this, InstagramUserInfoActivity::class.java)
            )
        }
        my_list.setOnClickListener {
            startActivity(
                Intent(this, InstagramMyPostActivity::class.java)
            )
        }

    }

    private fun getPicture() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        intent.type = "image/*"
        startActivityForResult(intent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1000) {
            val uri: Uri = data!!.data!!
            filePath = getImageFilePath(uri)
        }
    }

    private fun getImageFilePath(contentUri: Uri): String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri, projection, null, null, null)
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    private fun uploadPost() {
        val file = File(filePath)

        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"), getContent())
        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    finish()
                    startActivity(Intent(this@InstagramUploadActivity, InstagramMyPostActivity::class.java))
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("patht", "fail")
            }
        })
    }


    private fun getContent(): String {
        return content_input.text.toString()
    }

}