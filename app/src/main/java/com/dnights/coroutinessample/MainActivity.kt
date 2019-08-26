package com.dnights.coroutinessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initJavaThread()
        initAsyncTask()
        initRX()
        initCoroutine()
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

    fun initAsyncTask(){
        var asyncTask: AndroidAsyncTask? = null

        button_AsyncTask.setOnClickListener {
            if(asyncTask != null){
                asyncTask?.cancel(false)
                button_AsyncTask.text = "start AsyncTask"
                asyncTask = null
                return@setOnClickListener
            }
            asyncTask = AndroidAsyncTask(progessBar_AsyncTask)
            asyncTask?.execute()
            button_AsyncTask.text = "cancel AsyncTask"
        }
    }

    fun initRX(){
        var isRxRun = false

        button_RxKotlin.setOnClickListener {
            if(isRxRun){
                ReactiveX.cancelRxKotlin()
                button_RxKotlin.text = "start RxKotlin"
                isRxRun = false
                return@setOnClickListener
            }

            ReactiveX.startRxKotlin(progessBar_Rx)
            button_RxKotlin.text = "cancel RxKotlin"
            isRxRun = true
        }
    }

    fun initCoroutine(){
        var isCoroutineRun = false

        button_Coroutine.setOnClickListener {
            if(isCoroutineRun){
                Coroutines.cancelCoroutine()
                button_Coroutine.text = "start Coroutine"
                isCoroutineRun = false
                return@setOnClickListener
            }

            Coroutines.startCoroutine(progessBar_Coroutine)
            button_Coroutine.text = "cancel Coroutine"
            isCoroutineRun = true
        }
    }

}
