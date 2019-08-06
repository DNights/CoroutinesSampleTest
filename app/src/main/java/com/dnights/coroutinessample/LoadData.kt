package com.dnights.coroutinessample

import io.reactivex.Observable

object LoadData {

    fun loadHelloWrold() : String{
        return "Hello World!!!"
    }

    fun loadHelloWorldRx() : Observable<String> {
        return Observable.just("Hello World!!!")
    }

}