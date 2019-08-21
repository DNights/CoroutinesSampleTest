package com.dnights.coroutinessample

import android.widget.ProgressBar
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

object ReactiveX {

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    fun startRxKotlin(progessbarRx: ProgressBar) {

        Observable
            .intervalRange(PROGRESS_START.toLong(),
                PROGRESS_MAX.toLong(),
                0,
                (JOB_TIME / PROGRESS_MAX).toLong(),
                TimeUnit.MILLISECONDS)
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                // Show progress from UI thread
            }
            .doOnDispose {
                // Hide Progress from UI thread
            }
            .subscribe{
                // UI data update from UI thread
                progessbarRx.progress = it.toInt()
            }.let {

            }


    }

}