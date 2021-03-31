package com.soten.androidstudio.learn.boostcourse.server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import java.lang.UnsupportedOperationException
import java.net.ServerSocket

class ChatService : Service() {

    override fun onCreate() {
        super.onCreate()
        val thread = ServerThread()
        thread.start()
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not Yet")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        return super.onStartCommand(intent, flags, startId)
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