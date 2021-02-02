package com.soten.androidstudio.udemylearn.view.main.home.presenter

interface HomeContract {

    interface View {
        fun showProgress()
        fun hideProgress()

        fun showLoadFail()
        fun showLoadFail(message: String)
    }

    interface Presenter {

        fun loadFlickrImage()
    }
}