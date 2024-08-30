package com.example.assignmentapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.assignmentapplication.ui.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TodoDetailsActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_main_layout_container_isDisplayed() {
        onView(withId(R.id.layout_container)).check(
            matches(
                isDisplayed()
            )
        )
    }

    @Test
    fun test_recyclerView_isDisplayed() {
        onView(withId(R.id.recyclerView)).check(
            matches(
                isDisplayed()
            )
        )
    }
}