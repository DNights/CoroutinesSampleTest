package com.dnights.coroutinessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_Thread.setOnClickListener {
            JavaThread.startThread(progessBar_Thread)
        }

        button_AsyncTask.setOnClickListener {
            AndroidAsyncTask.startAsyncTask(progessBar_AsyncTask)
        }

        button_RxKotlin.setOnClickListener {
            ReactiveX.startRxKotlin(progessBar_Rx)
        }

        button_Coroutine.setOnClickListener {
            Coroutines.startCoroutine(progessBar_Coroutine)
        }
    }
}
