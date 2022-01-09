package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    companion object {
        val PREF = "pref"
        val KEY = "key"
    }

    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    lateinit var pref: SharedPreferences

    var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            textSecondsElapsed.post {
                textSecondsElapsed.setText("Seconds elapsed: " + secondsElapsed++)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)

        pref = getSharedPreferences(PREF, MODE_PRIVATE)

        if (pref.contains(KEY))
            secondsElapsed = pref.getInt(KEY, 0)

        backgroundThread.start()
    }

    override fun onStart() {
        super.onStart()

        if (pref.contains(KEY))
            secondsElapsed = pref.getInt(KEY, 0)
    }

    override fun onStop() {
        super.onStop()

        pref.edit()
            .putInt(KEY, secondsElapsed)
            .apply()
    }

}
