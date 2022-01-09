package ru.spbstu.icc.kspt.lab2.continuewatch

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    companion object {
        const val PREF = "pref"
        const val KEY = "key"
    }

    private var secondsElapsed: Int = 0

    private lateinit var textSecondsElapsed: TextView
    private lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)

        pref = getSharedPreferences(PREF, MODE_PRIVATE)

        if (pref.contains(KEY)) {
            secondsElapsed = pref.getInt(KEY, 0)
        }

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                while (true) {
                    delay(1000)
                    textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        if (pref.contains(KEY)) {
            secondsElapsed = pref.getInt(KEY, 0)
        }
    }

    override fun onStop() {
        super.onStop()

        pref.edit()
            .putInt(KEY, secondsElapsed)
            .apply()
    }
}
