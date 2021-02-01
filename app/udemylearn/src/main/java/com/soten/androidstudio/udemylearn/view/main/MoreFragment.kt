package com.soten.androidstudio.udemylearn.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.soten.androidstudio.udemylearn.R
import kotlinx.android.synthetic.main.fragment_etc.*

class MoreFragment() : Fragment() {

    companion object {
        const val KEY_TITLE = "key-title"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_etc, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.text = (arguments?.getInt(CameraFragment.KEY_TITLE) ?: 0).toString()
    }

}