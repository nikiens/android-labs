package com.example.nav1

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Activity2 : BaseActivity() {

    companion object {
        const val ACTIVITY_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val buttonToFirst = findViewById<Button>(R.id.bnToFirst)
        buttonToFirst.setOnClickListener { onClickToFirst() }

        val buttonToThird = findViewById<Button>(R.id.bnToThird)
        buttonToThird.setOnClickListener { onClickToThird() }
    }

    private fun onClickToFirst() {
        finish()
    }

    private fun onClickToThird() {
        val intent = Intent(this, Activity3::class.java)

        startActivityForResult(intent, ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == ACTIVITY_REQUEST_CODE)
            finish()
    }
}