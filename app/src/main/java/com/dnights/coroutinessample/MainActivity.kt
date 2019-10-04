package com.dnights.coroutinessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var javaThread: JavaThread? = null
    var javaRunnable: Thread? = null
    var asyncTask: AndroidAsyncTask? = null
    var isRxRun = false
    var isCoroutineRun = false

    var isAllRun = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initButton()
    }

    private fun initButton() {
        button_Thread.setOnClickListener {
            initJavaThread()
        }

        button_Runnable.setOnClickListener {
            initJavaRunnable()
        }

        button_AsyncTask.setOnClickListener {
            initAsyncTask()
        }

        button_RxKotlin.setOnClickListener {
            initRX()
        }

        button_Coroutine.setOnClickListener {
            initCoroutine()
        }

        button_All.setOnClickListener {
            initJavaThread()
            initAsyncTask()
            initRX()
            initCoroutine()

            if(isAllRun){
                button_All.text = "Start All"
                isAllRun = false
                return@setOnClickListener
            }

            button_All.text = "Cancel All"
            isAllRun = true
        }
    }

    fun initJavaThread(){
        if(javaThread != null){
            javaThread?.interrupt()
            button_Thread.text = "start Thread"
            javaThread = null
            return
        }

        javaThread = JavaThread(progessBar_Thread)
        javaThread?.start()
        button_Thread.text = "cancel Thread"
    }

    fun initJavaRunnable(){
        if(javaRunnable != null){
            javaRunnable?.interrupt()
            button_Runnable.text = "start Runnable"
            javaRunnable = null
            return
        }

        javaRunnable = Thread(JavaRunnable(progessBar_Runnable))
        javaRunnable?.start()
        button_Runnable.text = "cancel Runnable"
    }

    fun initAsyncTask(){
        if(asyncTask != null){
            asyncTask?.cancel(true)
            button_AsyncTask.text = "start AsyncTask"
            asyncTask = null
            return
        }

        asyncTask = AndroidAsyncTask(progessBar_AsyncTask)
        asyncTask?.execute()
        button_AsyncTask.text = "cancel AsyncTask"
    }

    fun initRX(){
        if(isRxRun){
            ReactiveX.cancelRxKotlin()
            button_RxKotlin.text = "start RxKotlin"
            isRxRun = false
            return
        }

        ReactiveX.startRxKotlin(progessBar_Rx)
        button_RxKotlin.text = "cancel RxKotlin"
        isRxRun = true
    }

    fun initCoroutine(){
        if(isCoroutineRun){
            Coroutines.cancelCoroutine()
            button_Coroutine.text = "start Coroutine"
            isCoroutineRun = false
            return
        }

        Coroutines.startCoroutine(progessBar_Coroutine)
        button_Coroutine.text = "cancel Coroutine"
        isCoroutineRun = true
    }

}
