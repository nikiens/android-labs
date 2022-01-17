package com.example.imageloader

import android.app.Application
import java.util.concurrent.Executors
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class ImageLoaderApp: Application() {

    private val tpe = ThreadPoolExecutor(1, 1,
        60L, TimeUnit.SECONDS,
        SynchronousQueue()
    ) { r ->
        Thread(r, "Background thread")
    }
    val executor = tpe

    init {
        tpe.allowCoreThreadTimeOut(true)
    }

}