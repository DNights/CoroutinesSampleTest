package com.dnights.coroutinessample

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ProgressBar

class JavaRunnable(private val progessbarRunnable: ProgressBar) :Runnable{

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    override fun run() {
        Handler(Looper.getMainLooper()).post {
            // show Progress on UI Thread
            progessbarRunnable.progress = 0
        }

        try{
            for (i in PROGRESS_START..PROGRESS_MAX) {
                Thread.sleep((JOB_TIME / PROGRESS_MAX).toLong())
                progessbarRunnable.progress = i
                Log.d("test", "JavaRunnable progessbarRunnable.progress = ${progessbarRunnable.progress}")
            }
        }catch (e:InterruptedException){
            e.printStackTrace()
            Log.d("test", "JavaRunnable end")
        }

        Handler(Looper.getMainLooper()).post {
            // UI data update from UI thread
            // Hide Progress from UI thread
        }
    }

}