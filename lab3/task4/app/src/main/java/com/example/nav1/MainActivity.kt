package com.example.nav1

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToSecond = findViewById<Button>(R.id.buttonToSecond)
        buttonToSecond.setOnClickListener { onClickToSecond() }
    }

    private fun onClickToSecond() {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }
}