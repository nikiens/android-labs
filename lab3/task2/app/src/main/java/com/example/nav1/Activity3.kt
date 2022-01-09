package com.example.nav1

import android.os.Bundle
import android.widget.Button

class Activity3 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val buttonToSecond = findViewById<Button>(R.id.bnToSecond)
        buttonToSecond.setOnClickListener { onClickToSecond() }

        val buttonToFirst = findViewById<Button>(R.id.bnToFirst)
        buttonToFirst.setOnClickListener { onClickToFirst() }
    }

    private fun onClickToSecond() {
        finish()
    }

    private fun onClickToFirst() {
        setResult(RESULT_OK)
        finish()
    }
}