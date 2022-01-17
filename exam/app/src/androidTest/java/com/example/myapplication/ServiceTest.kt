package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ServiceTestRule
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.any
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ServiceTest {

    @get:Rule
    val serviceRule = ServiceTestRule()

    @Test
    fun testService() {
        val intent = Intent(
            ApplicationProvider.getApplicationContext<Context>(),
            RandomIntService::class.java
        )

        val binder = serviceRule.bindService(intent)
        val service = IGetRandomInterface.Stub.asInterface(binder)

        assertThat(service.nextRandomInt(), `is`(any(Int::class.java)))
    }

}