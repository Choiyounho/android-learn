package com.soten.androidstudio.learn.fastcampus.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.soten.androidstudio.learn.R

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        tabLayout.addTab(tabLayout.newTab().setText("ONE"))
        tabLayout.addTab(tabLayout.newTab().setText("TWO"))
        tabLayout.addTab(tabLayout.newTab().setText("THREE"))

        val viewPager: ViewPager = findViewById(R.id.view_pager)

        viewPager.adapter = FragmentPagerAdapter(supportFragmentManager, 3)

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
        // -> 페이져가 이동했을 때 탭을 이동시키는 코드
    }

}

class FragmentPagerAdapter(fragmentManager: FragmentManager, private val tabCount: Int) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Fragment1()
            }
            1 -> {
                Fragment2()
            }
            2 -> {
                Fragment3()
            }
            else -> {
                Fragment1()
            }
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}
