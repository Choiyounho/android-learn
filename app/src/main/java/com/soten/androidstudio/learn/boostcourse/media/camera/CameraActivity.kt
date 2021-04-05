package com.soten.androidstudio.learn.boostcourse.media.camera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R

class CameraActivity : AppCompatActivity() {

    private val permissionList = arrayOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.RECEIVE_SMS,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private lateinit var currentPhotoPath: String

    private val imageView: ImageView by lazy {
        findViewById(R.id.img_camera)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        checkPermission()

        val btn = findViewById<Button>(R.id.btn_camera)
        btn.setOnClickListener {
            capture()
        }
    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission in permissionList) {
                if (checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_DENIED) {
                    requestPermissions(permissionList, 0)
                }
            }
        }
    }

    private fun capture() {
        startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), 101)
//            .also { takePictureIntent ->
//            takePictureIntent.resolveActivity(packageManager)?.also {
                // 사진 파일을 만듭니다.
//                val photoFile: File? = try {
//                    createImageFile()
//                } catch (ex: IOException) {
//                    // Error occurred while creating the File
//                    Log.d("test", "error: $ex")
//                    null
//                }
//                var photoFile: File?
//                // photoUri를 보내는 코드
//                photoFile?.also {
//                    val photoURI: Uri = FileProvider.getUriForFile(
//                        this,
//                        "com.soten.androidstudio.learn.boostcourse.media.camera",
//                        it
//                    )
//                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
//                    startActivityForResult(takePictureIntent, 101)
//                }
//            }
//        }

    }

//    private fun createImageFile(): File? {
//        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//        val storageDir: File? = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
//        return File.createTempFile(
//            "JPEG_${timeStamp}_", /* prefix */
//            ".jpg", /* suffix */
//            storageDir /* directory */
//        ).apply {
//            // Save a file: path for use with ACTION_VIEW intents
//            currentPhotoPath = absolutePath
//            Log.d("test", "currentPhotoPath : $currentPhotoPath")
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 101) {
            val bundle = data?.extras
            val bitmap = bundle?.get("data") as Bitmap
            imageView.setImageBitmap(bitmap)
//            galleryAddPic()
//            setPic()
        }
    }

    private fun setPic() {
        val targetW = imageView.width
        val targetH = imageView.height
        val bmOptions = BitmapFactory.Options().apply {
            inJustDecodeBounds = true
            val photoW: Int = outWidth
            val photoH: Int = outHeight
            // 이미지 배율 변수
            val scaleFactor: Int = Math.min(photoW / targetW, photoH / targetH)
            inJustDecodeBounds = false
            inSampleSize = scaleFactor
        }
        BitmapFactory.decodeFile(currentPhotoPath, bmOptions)?.also { bitmap ->
            imageView.setImageBitmap(bitmap)
        }
    }

//    private fun galleryAddPic() {
//        Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
//            Log.d("test", "currentPhotoPath2 : $currentPhotoPath")
//            val f = File(currentPhotoPath)
//            mediaScanIntent.data = Uri.fromFile(f)
//            sendBroadcast(mediaScanIntent)
//        }
//    }
}