package com.soten.androidstudio.learn.fastcampus

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.soten.androidstudio.learn.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask(findViewById(R.id.network_recycler_view)
        , LayoutInflater.from(this@NetworkActivity)
        ).execute()
    }

}

class NetworkTask(val recyclerView: RecyclerView, val inflater: LayoutInflater) : AsyncTask<Any?, Any?, Array<PersonFromServer>>() {

    override fun onPostExecute(result: Array<PersonFromServer>?) {
        val adapter = PerosonAdapter(result, inflater)
        recyclerView.adapter = adapter
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<PersonFromServer> {

        val urlString: String = "http://mellowcode.org/json/students/"
        val url: URL = URL(urlString)
        val connection: HttpURLConnection =  url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json/")

        var buffer = ""
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            Log.d("connn", "inputstream : ${connection.inputStream}")
            val reader = BufferedReader(InputStreamReader(
                connection.inputStream
                , "UTF-8")
            )
            buffer = reader.readLine()
        }

        return Gson().fromJson(buffer, Array<PersonFromServer>::class.java)
    }
}

class PerosonAdapter(
    val personList: Array<PersonFromServer>?, val inflater: LayoutInflater,
): RecyclerView.Adapter<PerosonAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView
        val age: TextView
        val intro: TextView

        init {
            name = itemView.findViewById(R.id.tv_network_name)
            age = itemView.findViewById(R.id.tv_network_age)
            intro = itemView.findViewById(R.id.tv_network_intro)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_network, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = personList!![position].name ?: ""
        holder.age.text = personList[position].age.toString()
        holder.intro.text = personList[position].intro ?: ""
    }

}