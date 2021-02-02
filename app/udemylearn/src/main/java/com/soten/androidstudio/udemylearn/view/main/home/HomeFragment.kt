package com.soten.androidstudio.udemylearn.view.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soten.androidstudio.udemylearn.R
import com.soten.androidstudio.udemylearn.data.source.flickr.FlickrRepository
import com.soten.androidstudio.udemylearn.data.source.image.ImageRepository
import com.soten.androidstudio.udemylearn.view.main.home.adapter.ImageRecyclerAdapter
import com.soten.androidstudio.udemylearn.view.main.home.presenter.HomeContract
import com.soten.androidstudio.udemylearn.view.main.home.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment,
            FlickrRepository,
            imageRecyclerAdapter)
    }

    // API 최신화로 context 대신 requireContext 사용
    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadFlickrImage()

        recycler_view.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recycler_view?.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showLoadFail() {
        if (isDetached) return

        Toast.makeText(context, "Load Fail", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadFail(message: String) {
        if (isDetached) return

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = recyclerView.childCount
            val totalItemCount = imageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if (!homePresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 3) {
                homePresenter.loadFlickrImage()
            }
        }
    }
}