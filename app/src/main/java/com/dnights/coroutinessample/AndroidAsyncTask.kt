package com.dnights.coroutinessample

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.widget.ProgressBar

object AndroidAsyncTask {

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    fun startAsyncTask(progressAsyncTask: ProgressBar) {
        val loadData = @SuppressLint("StaticFieldLeak")
        object : AsyncTask<Unit, Int, Int>() {

            override fun doInBackground(vararg params: Unit?): Int {
                for(i in PROGRESS_START..PROGRESS_MAX){
                    Thread.sleep((JOB_TIME / PROGRESS_MAX).toLong())
                    publishProgress(i)
                }

                return -1
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                progressAsyncTask.progress = values[0] ?: -1
            }

            override fun onPreExecute() {
                super.onPreExecute()
                // Show progress from UI thread
                progressAsyncTask.progress = 0
            }

            override fun onPostExecute(result: Int?) {
                super.onPostExecute(result)
                // UI data update from UI thread
                // Hide Progress from UI thread

            }
        }
        loadData.execute(Unit)
    }
}