package com.dnights.coroutinessample

import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import java.lang.Thread.sleep

class JavaThread(private val progessbarThread: ProgressBar) : Thread() {

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    override fun run() {
        super.run()
        Handler(Looper.getMainLooper()).post {
            // show Progress on UI Thread
            progessbarThread.progress = 0
        }

        try{
            for (i in PROGRESS_START..PROGRESS_MAX) {
                sleep((JOB_TIME / PROGRESS_MAX).toLong())
                progessbarThread.progress = i
            }
        }catch (e:InterruptedException){
            e.printStackTrace()
        }

        Handler(Looper.getMainLooper()).post {
            // UI data update from UI thread
            // Hide Progress from UI thread
        }

    }

}