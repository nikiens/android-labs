package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITest {
    @Test
    fun testButton() {
        launchActivity<MainActivity>()
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textView)).check(matches(not(withText("Random Number"))))

    }
}