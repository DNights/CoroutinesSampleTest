package com.dnights.coroutinessample

import android.util.Log
import android.widget.ProgressBar
import kotlinx.coroutines.*

object Coroutines {

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    var job = Job()

    fun startCoroutine(progessbarCoroutine: ProgressBar) {
        CoroutineScope(Dispatchers.Main + job).launch {
            // Show progress from UI thread
            progessbarCoroutine.progress = 0

            val coroutineContext = Dispatchers.Default + job

            // background thread
            withContext(CoroutineScope(coroutineContext).coroutineContext) {
                // background thread
                for (i in PROGRESS_START..PROGRESS_MAX) {
                    delay((JOB_TIME / PROGRESS_MAX).toLong())
                    progessbarCoroutine.progress = i
                    Log.d(
                        "test",
                        "Coroutines progessbarCoroutine.progress = ${progessbarCoroutine.progress}"
                    )
                }
            }
            // UI data update from UI thread
            // Hide Progress from UI thread
        }
    }

    fun cancelCoroutine() {
        job.cancel()
        job = Job()
        Log.d("test", "Coroutines cancelCoroutine")
    }
}