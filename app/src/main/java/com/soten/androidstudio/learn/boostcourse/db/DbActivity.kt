package com.soten.androidstudio.learn.boostcourse.db

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.soten.androidstudio.learn.R
import java.lang.Exception

class DbActivity : AppCompatActivity() {

    private val editText: EditText by lazy {
        findViewById(R.id.et_db)
    }

    private val dbText: TextView by lazy {
        findViewById(R.id.tv_db)
    }

    private val dbMakeBtn: Button by lazy {
        findViewById(R.id.btn_db_make)
    }

    private val dbAddBtn: Button by lazy {
        findViewById(R.id.btn_db_add)
    }

    private val editText2: EditText by lazy {
        findViewById(R.id.et_db_2)
    }

    private val editText3: EditText by lazy {
        findViewById(R.id.et_db_3)
    }

    private val editText4: EditText by lazy {
        findViewById(R.id.et_db_4)
    }

    private val editText5: EditText by lazy {
        findViewById(R.id.et_db_5)
    }

    private val dbSelectBtn: Button by lazy {
        findViewById(R.id.btn_db_select)
    }

    private lateinit var database: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        val btn = findViewById<Button>(R.id.btn_db_open)

        btn.setOnClickListener {
            val databaseName = editText.text.toString()
            openDatabase(databaseName)
        }


    }

    private fun openDatabase(databaseName: String) {
        if (databaseName == "") {
            Toast.makeText(applicationContext, "내용을 입력해주세요", Toast.LENGTH_SHORT).show()
            return
        }

        printing("openDatabase() 호출")

        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null)

        database.let {
            printing("데이터 베이스 오픈됨")
        }
    }


    private fun printing(data: String) {
        dbText.append("$data \n")
    }

}