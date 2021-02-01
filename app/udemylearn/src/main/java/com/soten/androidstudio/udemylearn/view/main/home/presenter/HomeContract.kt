package com.soten.androidstudio.udemylearn.view.main.home.presenter

interface HomeContract {

    interface View {
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter {
        fun loadImage()
    }
}