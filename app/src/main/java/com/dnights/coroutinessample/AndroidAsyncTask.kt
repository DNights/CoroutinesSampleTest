package com.dnights.coroutinessample

import android.os.AsyncTask
import android.widget.TextView
import com.dnights.coroutinessample.LoadData.loadHelloWrold

object AndroidAsyncTask {

    fun startAsyncTask(textView: TextView) {
        val loadData = object : AsyncTask<Unit, Unit, String>() {
            override fun doInBackground(vararg params: Unit?): String {
                return loadHelloWrold()
            }

            override fun onPreExecute() {
                super.onPreExecute()
                // Show progress from UI thread
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                // UI data update from UI thread
                // Hide Progress from UI thread
                textView.text = result
            }
        }
        loadData.execute(Unit)
    }
}