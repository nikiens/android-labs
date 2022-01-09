package com.example.nav1

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Activity2 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val buttonToFirst = findViewById<Button>(R.id.buttonToFirst)
        buttonToFirst.setOnClickListener { onClickToFirst() }

        val buttonToThird = findViewById<Button>(R.id.buttonToThird)
        buttonToThird.setOnClickListener { onClickToThird() }
    }

    private fun onClickToFirst() {
        finish()
    }

    private fun onClickToThird() {
        val intent = Intent(this, Activity3::class.java)

        startActivity(intent)
    }
}