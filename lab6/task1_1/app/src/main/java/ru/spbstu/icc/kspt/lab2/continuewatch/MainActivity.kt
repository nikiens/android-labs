package ru.spbstu.icc.kspt.lab2.continuewatch

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREF = "pref"
        const val KEY = "key"
        const val TAG = "Threads"
    }

    private var secondsElapsed: Int = 0

    private lateinit var textSecondsElapsed: TextView
    private lateinit var pref: SharedPreferences
    private lateinit var thread: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)

        pref = getSharedPreferences(PREF, MODE_PRIVATE)

        if (pref.contains(KEY)) {
            secondsElapsed = pref.getInt(KEY, 0)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        if (pref.contains(KEY)) {
            secondsElapsed = pref.getInt(KEY, 0)
        }

        thread = thread(name = "Background thread") {
            try {
                while (!Thread.currentThread().isInterrupted) {
                    Thread.sleep(1000)
                    textSecondsElapsed.post {
                        textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
                    }
                }
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
    }

    override fun onStop() {
        super.onStop()

        pref.edit()
            .putInt(KEY, secondsElapsed)
            .apply()

        thread.interrupt()
    }

}
