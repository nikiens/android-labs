package com.example.imageloader

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val urlStr = "https://picsum.photos/seed/picsum/200/300"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView = findViewById<ImageView>(R.id.imageView)

        ImageLoaderApp.executor.submit {
            val url = URL(urlStr)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            imgView.post {
                imgView.setImageBitmap(bitmap)
            }
        }
    }
}