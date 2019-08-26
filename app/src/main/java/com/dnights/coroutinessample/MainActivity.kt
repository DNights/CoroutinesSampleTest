package com.dnights.coroutinessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initJavaThread()

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

    fun initJavaThread(){
        var javaThread: JavaThread? = null

        button_Thread.setOnClickListener {
            if(javaThread != null){
                javaThread?.interrupt()
                button_Thread.text = "start Thread"
                javaThread = null
                return@setOnClickListener
            }
            javaThread = JavaThread(progessBar_Thread)
            javaThread?.start()
            button_Thread.text = "cancel Thread"

        }
    }
}
