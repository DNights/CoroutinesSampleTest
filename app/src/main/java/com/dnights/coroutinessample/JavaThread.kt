package com.dnights.coroutinessample

import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import java.lang.Thread.sleep

object JavaThread {

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    fun startThread(progessbarThread: ProgressBar) {
        val thread = Thread(Runnable {
            Handler(Looper.getMainLooper()).post {
                // show Progress on UI Thread
                progessbarThread.progress = 0
            }

            for(i in PROGRESS_START..PROGRESS_MAX){
                sleep((JOB_TIME / PROGRESS_MAX).toLong())
                progessbarThread.progress = i
            }

            Handler(Looper.getMainLooper()).post {
                // UI data update from UI thread
                // Hide Progress from UI thread

            }
        })

        thread.start()
    }

}