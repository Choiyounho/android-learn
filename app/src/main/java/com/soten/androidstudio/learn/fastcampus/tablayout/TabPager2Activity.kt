package com.soten.androidstudio.learn.fastcampus.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.soten.androidstudio.learn.R

// 프래그먼트를 이용하지 않고 탭페이져를 이용 (프래그먼트는 무거운 리소스다)
class TabPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        tabLayout.addTab(tabLayout.newTab().setText("ONE"))
        tabLayout.addTab(tabLayout.newTab().setText("TWO"))
        tabLayout.addTab(tabLayout.newTab().setText("THREE"))

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = ThreePageAdapter(LayoutInflater.from(this@TabPager2Activity))

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}

class ThreePageAdapter(private val layoutInflater: LayoutInflater) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any { // 뷰를 그려줌
        when(position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.fragment_two, container, false)
                container.addView(view)
                return view
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.fragment_three, container, false)
                container.addView(view)
                return view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
    }


}