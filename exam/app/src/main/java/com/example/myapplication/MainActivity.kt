package com.example.myapplication

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var IGetRandomService: IGetRandomInterface? = null

    val TAG = "BoundService"

    val mConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            IGetRandomService = IGetRandomInterface.Stub.asInterface(p1)
            Log.i(TAG, "Service bind success")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            IGetRandomService = null
            Log.i(TAG, "Service disconnected")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent()
        intent.setClassName("com.example.myapplication",
            "com.example.myapplication.RandomIntService")

        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            val rand = IGetRandomService?.nextRandomInt()

            textView.text = rand.toString()
        }
    }

}