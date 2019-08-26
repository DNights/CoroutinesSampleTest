package com.dnights.coroutinessample

import android.widget.ProgressBar
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

object ReactiveX {

    private val PROGRESS_MAX = 100
    private val PROGRESS_START = 0
    private val JOB_TIME = 4000 // ms

    val disposables by lazy {
        CompositeDisposable()
    }

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
            }.apply { disposables.add(this) }
    }

    fun cancelRxKotlin() {
        disposables.clear()
    }

}