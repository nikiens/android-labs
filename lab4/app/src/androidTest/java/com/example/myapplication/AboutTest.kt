package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.util.openAbout
import com.example.nav1.util.ContentDescription
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AboutTest {

    @Test
    fun testActionFromMainFragToAbout() {
        /* When */
        launchActivity<MainActivity>()
        openAbout()

        /* Then */
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromAboutToMainFragUsingBack() {
        /* When */
        launchActivity<MainActivity>()
        openAbout()
        pressBack()

        /* Then */
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromAboutToMainFragUsingUp() {
        /* When */
        launchActivity<MainActivity>()
        com.example.myapplication.util.openAbout()
        onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
            .perform(click())
        /* Then */
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromFrag2ToAbout() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()

        /* Then */
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromAboutToFrag2UsingBack() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        pressBack()

        /* Then */
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromAboutToFrag2UsingUp() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
            .perform(click())
        /* Then */
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromFrag3ToAbout() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()

        /* Then */
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromAboutToFrag3UsingBack() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        pressBack()

        /* Then */
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }

    @Test
    fun testActionFromAboutToFrag3UsingUp() {
        /* When */
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
            .perform(click())

        /* Then */
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }

    @Test(expected = NoMatchingViewException::class)
    fun testNoOpenAboutFromAbout() {
        launchActivity<MainActivity>()
        openAbout()
        openAbout()
    }
}