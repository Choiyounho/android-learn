package com.soten.androidstudio.learn.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.soten.androidstudio.learn.R

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {

    override fun onDataPass(data: String?) {
        Log.d("pass", "" + data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")

        val openButton: Button = findViewById(R.id.button_open)
        val fragmentOne: FragmentOne = FragmentOne()

        // 프래그먼트에 data를 넣어주는 방법
        val bundle: Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        openButton.setOnClickListener {
            // 프래그먼트를 동적으로 작동하는 방법
            // 프래그먼트를 붙이는 방법 replace / add
            val fragmentManager: FragmentManager = supportFragmentManager
            /*
               Transaction
               작업의 단위 -> 시작과 끝이 있다.
            */
            val fragmentTransaction: FragmentTransaction =
                fragmentManager.beginTransaction() // 트랜스액션을 시작하겠다.
            fragmentTransaction.replace(R.id.container, fragmentOne) // 할일
            fragmentTransaction.commit() // 끝
            /*
                끝내는 방법
                commit -> 여유로울 때 종료(좀 더 안정적)
                commitNow -> 지금 당장 종료
            */
        }

        val button2: Button = findViewById(R.id.button_close)

        button2.setOnClickListener {
            // 프래그먼트 remove / detach 방법
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }


}