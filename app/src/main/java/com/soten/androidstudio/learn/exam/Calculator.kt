package com.soten.androidstudio.learn.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.soten.androidstudio.learn.R

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var old = "0"
        var new = "0"

        val zero: TextView = findViewById(R.id.zero)
        val one: TextView = findViewById(R.id.one)
        val two: TextView = findViewById(R.id.two)
        val three: TextView = findViewById(R.id.three)
        val four: TextView = findViewById(R.id.four)
        val five: TextView = findViewById(R.id.five)
        val six: TextView = findViewById(R.id.six)
        val seven: TextView = findViewById(R.id.seven)
        val eight: TextView = findViewById(R.id.eight)
        val nine: TextView = findViewById(R.id.nine)
        val init: TextView = findViewById(R.id.init)
        val calculate: TextView = findViewById(R.id.calculate)
        val plus: TextView = findViewById(R.id.plus)
        val result: TextView = findViewById(R.id.result)

        zero.setOnClickListener {
            new += "0"
            result.text = new
        }

        one.setOnClickListener {
            new += "1"
            result.text = new
        }

        two.setOnClickListener {
            new += "2"
            result.text = new
        }

        three.setOnClickListener {
            new += "3"
            result.text = new
        }

        four.setOnClickListener {
            new += "4"
            result.text = new
        }

        five.setOnClickListener {
            new += "5"
            result.text = new
        }

        six.setOnClickListener {
            new += "6"
            result.text = new
        }

        seven.setOnClickListener {
            new += "7"
            result.text = new
        }

        eight.setOnClickListener {
            new += "8"
            result.text = new
        }

        nine.setOnClickListener {
            new += "9"
            result.text = new
        }

        init.setOnClickListener {
            old = "0"
            new = "0"
            result.text = "0"
        }

        plus.setOnClickListener {
            old = (old.toInt() + new.toInt()).toString()
            new = "0"
            result.text = old
        }

        calculate.setOnClickListener {
            old = (old.toInt() + new.toInt()).toString()
            new = "0"
            result.text = old
        }

    }
}