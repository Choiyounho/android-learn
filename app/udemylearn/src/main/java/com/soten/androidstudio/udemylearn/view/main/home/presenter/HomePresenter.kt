package com.soten.androidstudio.udemylearn.view.main.home.presenter

import com.soten.androidstudio.udemylearn.data.PhotoResponse
import com.soten.androidstudio.udemylearn.data.source.flickr.FlickrRepository
import com.soten.androidstudio.udemylearn.view.main.home.adapter.model.ImageRecyclerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val view: HomeContract.View,
    private val flickrRepository: FlickrRepository,
    private val imageRecyclerModel: ImageRecyclerModel
) : HomeContract.Presenter {

    var isLoading = false

    private val perPage = 50
    private var page = 0

    override fun loadFlickrImage() {
        flickrRepository.getSearchPhoto("Eiffel Tower", ++page, perPage)
            .enqueue(object : Callback<PhotoResponse> {
                override fun onResponse(
                    call: Call<PhotoResponse>,
                    response: Response<PhotoResponse>
                ) {
                    if (response?.isSuccessful) {
                        response.body().takeIf { it?.stat == "ok" }?.let {
                            page = it.photos.page

                            it.photos.photo.forEach {
                                imageRecyclerModel.addItem(it)
                            }
                            imageRecyclerModel.notifyDataSetChang()
                        } ?: let {
                            view.showLoadFail("Code ${response.body()?.code} message : ${response.body()?.message}")
                        }
                    } else {
                        view.showLoadFail()
                    }
                }

                override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                    view.hideProgress()
                    view.showLoadFail()

                    isLoading = false
                }
            })
    }

}