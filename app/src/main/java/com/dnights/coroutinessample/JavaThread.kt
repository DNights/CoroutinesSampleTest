package com.dnights.coroutinessample

import android.os.Handler
import android.os.Looper
import android.widget.TextView
import com.dnights.coroutinessample.LoadData.loadHelloWrold

object JavaThread {

    fun startThread(textView: TextView) {
        val thread = Thread(Runnable {
            Handler(Looper.getMainLooper()).post {
                // show Progress on UI Thread
            }

            val data = loadHelloWrold()

            Handler(Looper.getMainLooper()).post {
                // UI data update from UI thread
                // Hide Progress from UI thread
                textView.text = data
            }
        })

        thread.start()
    }


}