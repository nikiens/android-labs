package com.example.myapplication.util

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.myapplication.R

/*private fun openAboutViaBottomNav() {
    onView(withId(R.id.nav_view)).perform(click())
}

private fun openAboutViaDrawer() {
    // Open Drawer to click on navigation.
    onView(withId(R.id.drawer_layout))
        .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
        .perform(DrawerActions.open()); // Open Drawer

    // Start the screen of your activity.
    onView(withId(R.id.drawer_nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
}*/

private fun openAboutViaOptions() {
    openContextualActionModeOverflowMenu()
    onView(withText(R.string.title_about))
        .perform(click())
}

fun openAbout() = openAboutViaOptions()