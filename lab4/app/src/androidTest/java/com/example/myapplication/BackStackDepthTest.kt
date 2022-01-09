package com.example.myapplication

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.MainActivity
import com.example.myapplication.util.openAbout
import com.example.nav1.util.ContentDescription
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackStackDepthTest {

    @Test
    fun testFrag1DepthUsingBack() {
        /* Given */
        val activity = launchActivity<MainActivity>()

        /* When */
        pressBackUnconditionally()

        /* Then */
        assertEquals(activity.state, Lifecycle.State.DESTROYED)
    }

    @Test(expected = NoMatchingViewException::class)
    fun testFrag1DepthUsingUp() {
        val activity = launchActivity<MainActivity>()

        onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
            .perform(click())
    }

    @Test
    fun testFrag1AboutDepthUsingBack() {
        /* Given */
        val activity = launchActivity<MainActivity>()
        openAbout()

        /* When */
        repeat(2) { pressBackUnconditionally() }

        /* Then */
        assertEquals(activity.state, Lifecycle.State.DESTROYED)
    }

    @Test(expected = NoMatchingViewException::class)
    fun testFrag1AboutDepthUsingUp() {
        launchActivity<MainActivity>()

        repeat(2) {
            onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
                .perform(click())
        }
    }

    @Test
    fun testFrag2DepthUsingBack() {
        /* Given */
        val activity = launchActivity<MainActivity>()

        /* When */
        onView(withId(R.id.bnToSecond)).perform(click())
        repeat(2) { pressBackUnconditionally() }

        /* Then */
        assertEquals(activity.state, Lifecycle.State.DESTROYED)
    }

    @Test(expected = NoMatchingViewException::class)
    fun testFrag2DepthUsingUp() {
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())

        repeat(2) {
            onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
                .perform(click())
        }
    }

    @Test
    fun testFrag2AboutDepthUsingBack() {
        /* Given */
        val activity = launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()

        /* When */
        repeat(3) { pressBackUnconditionally() }

        /* Then */
        assertEquals(activity.state, Lifecycle.State.DESTROYED)
    }

    @Test(expected = NoMatchingViewException::class)
    fun testFrag2AboutDepthUsingUp() {
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()

        repeat(3) {
            onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
                .perform(click())
        }
    }

    @Test
    fun testFrag3DepthUsingBack() {
        /* Given */
        val activity = launchActivity<MainActivity>()

        /* When */
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        repeat(3) { pressBackUnconditionally() }

        /* Then */
        assertEquals(activity.state, Lifecycle.State.DESTROYED)
    }

    @Test(expected = NoMatchingViewException::class)
    fun testFrag3DepthUsingUp() {
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        repeat(3) {
            onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
                .perform(click())
        }
    }

    @Test
    fun testFrag3AboutDepthUsingBack() {
        /* Given */
        val activity = launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()

        /* When */
        repeat(4) { pressBackUnconditionally() }

        /* Then */
        assertEquals(activity.state, Lifecycle.State.DESTROYED)
    }

    @Test(expected = NoMatchingViewException::class)
    fun testFrag3AboutDepthUsingUp() {
        launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()

        repeat(4) {
            onView(withContentDescription(ContentDescription.NavUpContentDescriptionValue))
                .perform(click())
        }
    }

    @Test
    fun testBackStackMaxDepth() {
        /* When */
        val activity = launchActivity<MainActivity>()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        pressBackUnconditionally()
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())

        repeat(3) { pressBackUnconditionally() }

        /* Then */
        assertEquals(activity.state, Lifecycle.State.DESTROYED)
    }
}