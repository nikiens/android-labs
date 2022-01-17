package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder

import kotlin.random.Random

class RandomIntService : Service() {

    val binder = object : IGetRandomInterface.Stub() {
        override fun nextRandomInt(): Int {
            return Random.Default.nextInt()
        }
    }

    override fun onBind(intent: Intent): IBinder = binder



}