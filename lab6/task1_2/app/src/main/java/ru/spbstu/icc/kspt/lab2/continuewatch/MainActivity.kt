package ru.spbstu.icc.kspt.lab2.continuewatch

import android.annotation.SuppressLint
import android.app.Application
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Future

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREF = "pref"
        const val KEY = "key"
    }

    private var secondsElapsed: Int = 0

    private lateinit var textSecondsElapsed: TextView
    private lateinit var pref: SharedPreferences
    private lateinit var future: Future<*>

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

        future = (application as ContinueWatchApp).executorService.submit {
            while (true) {
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()

        pref.edit()
            .putInt(KEY, secondsElapsed)
            .apply()

        future.cancel(true)
    }
}
