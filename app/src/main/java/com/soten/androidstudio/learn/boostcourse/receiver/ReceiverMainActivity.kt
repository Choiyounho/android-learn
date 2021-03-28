package com.soten.androidstudio.learn.boostcourse.receiver

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R

class ReceiverMainActivity : AppCompatActivity() {

    private val permissionList = arrayOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.RECEIVE_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver_main)

        checkPermission()
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
}