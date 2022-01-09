package com.example.imageloader

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val urlStr = "https://picsum.photos/seed/picsum/200/300"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView = findViewById<ImageView>(R.id.imageView)

        lifecycleScope.launch(Dispatchers.IO) {
            val url = URL(urlStr)
            val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())

            withContext(Dispatchers.Main) { imgView.setImageBitmap(bitmap) }
        }
    }
}