package com.soten.androidstudio.learn.boostcourse.camera

import android.content.Context
import android.hardware.Camera
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException

class CameraSurfaceView : SurfaceView,
    SurfaceHolder.Callback {

    var mholder: SurfaceHolder? = null
    var camera: Camera? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        mholder = holder
        mholder?.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        camera = Camera.open()
        try {
            camera?.setPreviewDisplay(holder)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        camera?.startPreview()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        camera?.stopPreview()
        camera?.release()
        camera = null
    }

    fun capture(callback: Camera.PictureCallback?): Boolean {
        camera?.let {
            camera?.takePicture(null, null, callback)
            return true
        } ?: return false
    }

}