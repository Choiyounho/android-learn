package com.soten.androidstudio.learn.fastcampus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.soten.androidstudio.learn.R

class Listener : AppCompatActivity() {

    var number = 10

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listner)

        val helloText: TextView = findViewById(R.id.hello)

        val image: ImageView = findViewById(R.id.image)


        // (1), (2), (3) 기능을 동일 람다방식이 가장 최근

        // (1) 람다 표현식
        helloText.setOnClickListener {
            Log.d("click", "Click!")
            helloText.text = "안녕하세요"  // (4)
            image.setImageResource(R.drawable.ic_apple)
            number += 10
            Log.d("number", "" + number)
        }

    /*
         (2) 익명 함수 방법
         helloText.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "Click!")
            }
        })
    */

    /*
         (3) -> 이름이 필요한 경우(click)
        val click = object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "Click!")
            }
        }
        helloText.setOnClickListener(click)
    */


        // 뷰 조작 법
        // helloText.setText("안녕하세요") 클릭리스너 함수에 작성하면 클릭 시 발생 (4) 참고
    }

}