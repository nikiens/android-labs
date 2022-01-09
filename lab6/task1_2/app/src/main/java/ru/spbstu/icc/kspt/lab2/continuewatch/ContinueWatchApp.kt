package ru.spbstu.icc.kspt.lab2.continuewatch

import android.app.Application
import java.util.concurrent.*

class ContinueWatchApp : Application() {

    init {
        tpe.allowCoreThreadTimeOut(true)
    }

    companion object {
        private val tpe = ThreadPoolExecutor(1, 1,
            60L, TimeUnit.SECONDS,
            SynchronousQueue()
        ) { r ->
            Thread(r, "Background thread")
        }
        val executorService = tpe
    }
}