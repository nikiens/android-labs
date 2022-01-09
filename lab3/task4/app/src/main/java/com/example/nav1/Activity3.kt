package com.example.nav1

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Activity3 : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val buttonToSecond = findViewById<Button>(R.id.buttonToSecond)
        buttonToSecond.setOnClickListener { onClickToSecond() }

        val buttonToFirst = findViewById<Button>(R.id.buttonToFirst)
        buttonToFirst.setOnClickListener { onClickToFirst() }

        val buttonToExtra = findViewById<Button>(R.id.buttonToExtra)
        buttonToExtra.setOnClickListener { onClickToExtra() }
    }

    private fun onClickToSecond() {
        finish()
    }

    private fun onClickToFirst() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun onClickToExtra() {
        val intent = Intent(this, ExtraActivity::class.java)
        startActivity(intent)
    }
}