package com.soten.androidstudio.learn.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.soten.androidstudio.learn.R

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList("$i 번째 자동차", "$i 순위 엔진"))
        }

        val container: LinearLayout = findViewById(R.id.addview_container)
        val inflater: LayoutInflater = LayoutInflater.from(this@AddViewActivity)
        for (i in 0 until carList.size) {
            val itemView = inflater.inflate(R.layout.item_view, null)
            val carNameView: TextView = itemView.findViewById(R.id.car_name)
            val carEngineView: TextView = itemView.findViewById(R.id.car_engine)

            carNameView.text = carList[i].name
            carEngineView.text = carList[i].engine
            container.addView(itemView)
        }

        container.setOnClickListener {

        }
    }
}

class CarForList(val name: String, val engine: String) {

}