package com.dnights.coroutinessample

import android.os.AsyncTask
import android.util.Log
import android.widget.ProgressBar

class AndroidAsyncTask(private val progressAsyncTask: ProgressBar) : AsyncTask<Unit, Int, Int>() {
    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    private var isCanceled = false

    override fun doInBackground(vararg params: Unit?): Int {
        for(i in PROGRESS_START..PROGRESS_MAX){
            if(isCanceled) return -1
            Thread.sleep((JOB_TIME / PROGRESS_MAX).toLong())
            publishProgress(i)
            Log.d("test", "AndroidAsyncTask doInBackground = ${i}")
        }

        return -1
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        progressAsyncTask.progress = values[0] ?: -1
        Log.d("test", "AndroidAsyncTask onProgressUpdate = ${progressAsyncTask.progress}")
    }

    override fun onPreExecute() {
        super.onPreExecute()
        // Show progress from UI thread
        progressAsyncTask.progress = 0
        Log.d("test", "AndroidAsyncTask onPreExecute")
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        // UI data update from UI thread
        // Hide Progress from UI thread
        Log.d("test", "AndroidAsyncTask onPostExecute")

    }

    override fun onCancelled() {
        super.onCancelled()
        isCanceled = true
        Log.d("test", "AndroidAsyncTask onCancelled")
    }
}