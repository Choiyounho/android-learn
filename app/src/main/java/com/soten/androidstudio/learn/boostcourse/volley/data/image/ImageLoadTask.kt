package com.soten.androidstudio.learn.boostcourse.volley.data.image

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL

class ImageLoadTask(
    private val urlString: String,
    private val image: ImageView
) : AsyncTask<Unit, Unit, Bitmap>() {

    companion object {
        var bitmapHash = HashMap<String, Bitmap>()
    }

    override fun doInBackground(vararg params: Unit?): Bitmap {
        if (bitmapHash.containsKey(urlString)) {
            var oldBitmap = bitmapHash.remove(urlString)
            oldBitmap.let {
                oldBitmap?.recycle()
                oldBitmap = null
            }
        }

        val url = URL(urlString)
        val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

        bitmapHash[urlString] = bitmap
        return bitmap
    }

    override fun onProgressUpdate(vararg values: Unit?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)

        image.setImageBitmap(result)
        image.invalidate()
    }

}