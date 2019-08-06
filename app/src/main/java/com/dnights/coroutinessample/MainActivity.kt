package com.dnights.coroutinessample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JavaThread.startThread(textview_hello_world)

        //AndroidAsyncTask.startAsyncTask(textview_hello_world)

        //ReactiveX.startRxKotlin(textview_hello_world)

        //Coroutines.startCoroutine(textview_hello_world)
    }
}
