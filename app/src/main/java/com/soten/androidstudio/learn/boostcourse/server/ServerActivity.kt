package com.soten.androidstudio.learn.boostcourse.server

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.soten.androidstudio.learn.R
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import java.net.ServerSocket

class ServerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server)

        val serverBtn = findViewById<Button>(R.id.btn_server)

        serverBtn.setOnClickListener {
            val thread = ServerThread()
            thread.start()
        }
    }

    class ServerThread : Thread() {
        override fun run() {
            super.run()
            val port = 5001

            try {
                val server = ServerSocket(port)
                Log.d("ServerThread", "서버가 실행 됨")

                while (true) {
                    val socket = server.accept()

                    val inStream = ObjectInputStream(socket.getInputStream())
                    val input = inStream.readObject()
                    Log.d("ServerThread", "input : $input")

                    val outputStream = ObjectOutputStream(socket.getOutputStream())
                    outputStream.writeObject(input)
                    outputStream.flush()

                    Log.d("ServerThread", "output")

                    socket.close()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}