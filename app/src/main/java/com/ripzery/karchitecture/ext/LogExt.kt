package com.ripzery.karchitecture.ext

import android.util.Log

/**
 * Created by Euro on 7/24/2017 AD.
 */
interface EuroLogger {
    val loggerTag: String
        get() = if(javaClass.simpleName.length < 23) javaClass.simpleName else javaClass.simpleName.substring(23)
}

fun EuroLogger.info(message: Any?){
    Log.i(loggerTag, message?.toString() ?: "null")
}

inline fun EuroLogger.info(message: () -> Any?){
    Log.i(loggerTag, message()?.toString() ?: "null")
}