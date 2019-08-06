package com.dnights.coroutinessample

import android.widget.TextView
import com.dnights.coroutinessample.LoadData.loadHelloWorldRx
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ReactiveX {

    fun startRxKotlin(textView: TextView){
        loadHelloWorldRx()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                // Show progress from UI thread
            }
            .doOnDispose {
                // Hide Progress from UI thread
            }
            .subscribe{
                // UI data update from UI thread
                textView.text = it
            }.let {

            }
    }

}