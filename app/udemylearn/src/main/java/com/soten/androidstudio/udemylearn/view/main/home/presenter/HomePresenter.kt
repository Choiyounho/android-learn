package com.soten.androidstudio.udemylearn.view.main.home.presenter

import android.os.AsyncTask
import com.soten.androidstudio.udemylearn.data.source.image.ImageRepository
import com.soten.androidstudio.udemylearn.view.main.home.adapter.model.ImageRecyclerModel

class HomePresenter(
    private val view: HomeContract.View,
    private val imageRepository: ImageRepository,
    private val imageRecyclerModel: ImageRecyclerModel
) : HomeContract.Presenter {

    var isLoading = false

    override fun loadImage() {
        ImageAsyncTask(this, view, imageRepository, imageRecyclerModel).execute()
    }

    class ImageAsyncTask(
        private val homePresenter: HomePresenter,
        private val view: HomeContract.View,
        private val imageRepository: ImageRepository,
        private val imageRecyclerModel: ImageRecyclerModel
    ) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg params: Unit?) {
            imageRepository.loadImageList({
                it.forEach {
                    imageRecyclerModel.addItem(it)
                }
            }, 10)
            Thread.sleep(1000)
        }

        override fun onPreExecute() {
            super.onPreExecute()

            homePresenter.isLoading = true
            view.showProgress()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            imageRecyclerModel.notifyDataSetChang()
            view.hideProgress()

            homePresenter.isLoading = false
        }
    }
}