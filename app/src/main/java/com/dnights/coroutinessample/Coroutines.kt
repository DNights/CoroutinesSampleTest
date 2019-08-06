package com.dnights.coroutinessample

import android.widget.TextView
import com.dnights.coroutinessample.LoadData.loadHelloWrold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {

    fun startCoroutine(textView: TextView){
        CoroutineScope(Dispatchers.Main).launch {
            // Show progress from UI thread
            var data = ""
            CoroutineScope(Dispatchers.Default).async {
                // background thread
                data = loadHelloWrold()
            }.await()
            // UI data update from UI thread
            // Hide Progress from UI thread
            textView.text = data
        }
    }


}