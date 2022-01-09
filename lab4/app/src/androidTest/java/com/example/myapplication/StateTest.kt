package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import com.example.myapplication.util.openAbout
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StateTest {

    @Test
    fun testFrag1State() {
        /* Given */
        launchActivity<MainActivity>()
        val device = UiDevice.getInstance(getInstrumentation())

        /* When */
        device.setOrientationLeft()

        /* Then */
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))

        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(withText(R.string.title_to_second)))
    }

    @Test
    fun testFrag2State() {
        /* Given */
        val device = UiDevice.getInstance(getInstrumentation())

        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())

        /* When */
        device.setOrientationLeft()

        /* Then */
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))

        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(withText(R.string.title_to_first)))

        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(matches(withText(R.string.title_to_third)))
    }

    @Test
    fun testFrag3State() {
        /* Given */
        val device = UiDevice.getInstance(getInstrumentation())

        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        /* When */
        device.setOrientationLeft()

        /* Then */
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))

        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(withText(R.string.title_to_first)))

        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(withText(R.string.title_to_second)))
    }

    @Test
    fun testAboutState() {
        /* Given */
        val device = UiDevice.getInstance(getInstrumentation())

        launchActivity<MainActivity>()
        openAbout()

        /* When */
        device.setOrientationLeft()

        /* Then */
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))

        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(withText(R.string.text_about)))
    }
}