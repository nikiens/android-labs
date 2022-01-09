package com.example.nav1

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nav1.MainActivity
import com.example.nav1.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @Test
    fun testFromFrag1ToFrag2() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())

        /* Then */
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun testFromFrag2ToFrag1() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())

        /* Then */
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testFromFrag2ToFrag3() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        /* Then */
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }

    @Test
    fun testFromFrag3ToFrag1() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())

        /* Then */
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testFromFrag3ToFrag2() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToSecond)).perform(click())

        /* Then */
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }
}