package com.soten.androidstudio.learn

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // 데이터 저장법
//        val sharedPreference = getSharedPreferences("sq1", Context.MODE_PRIVATE)
        /*
            Mode - MODE_PRIVATE : 생성한 application에서만 사용 가능
                 - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
                 - MODE_APPEND : 기존 Preference에 신규로 추가
                 - MODE_WORLD_READABLE : 다른 application에서도 사용가능 -> 읽기전용 (Deprecated)
                 - MODE_WORLD_WRITEABLE : 다른 application에서도 사용가능 -> 읽기, 쓰기 가능 (Deprecated)
         */

        val saveButton: Button = findViewById(R.id.button_sql)

        saveButton.setOnClickListener {
            val sharedPreference = getSharedPreferences("sq1", Context.MODE_PRIVATE)
            val edtior: SharedPreferences.Editor = sharedPreference.edit()
            edtior.putString("hello", "안녕하세요")
            edtior.putString("good Bye", "안녕히가세요")
            edtior.apply()
        }

        val loadButton: Button = findViewById(R.id.button_load)

        loadButton.setOnClickListener {
            val sharedPreference = getSharedPreferences("sq1", Context.MODE_PRIVATE)
            val value = sharedPreference.getString("hello", "데이터 없음")
            val value2 = sharedPreference.getString("good Bye", "데이터 없음2")
            Log.d("key-value", "Value : $value")
            Log.d("key-value", "Value2 : $value2")
        }

        val deleteButton: Button = findViewById(R.id.button_delete)

        deleteButton.setOnClickListener {
            val sharedPreference = getSharedPreferences("sq1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello")
            editor.apply()
        }

        val deleteAllButton: Button = findViewById(R.id.button_all_delete)

        deleteAllButton.setOnClickListener {
            val sharedPreference = getSharedPreferences("sq1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear()
            editor.apply()
        }
    }
}