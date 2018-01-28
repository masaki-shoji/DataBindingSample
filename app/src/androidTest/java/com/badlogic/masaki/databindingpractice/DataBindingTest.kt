package com.badlogic.masaki.databindingpractice

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.hamcrest.Matcher
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    private var mContext: Context? = null
    private var mActivity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mContext = InstrumentationRegistry.getTargetContext()
        mActivity = mActivityRule.activity
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        mContext = null
        mActivity = null
    }

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        assertEquals("com.badlogic.masaki.databindingpractice", mContext?.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun testDataBinding() {
        onView(withId(R.id.text1)).check(matches(withText("firstName!")))
        onView(withId(R.id.text2)).check(matches(withText("lastName!")))

        onView(isRoot()).perform(waitFor(3000))

        onView(withId(R.id.text1)).check(matches(withText("hogeeee")))
    }
}

fun waitFor(millis: Long): ViewAction {
    return object: ViewAction {
        override fun getDescription(): String = "wait for " + millis + "for action"

        override fun getConstraints(): Matcher<View> = isRoot()

        override fun perform(uiController: UiController?, view: View?) {
            uiController?.loopMainThreadForAtLeast(millis)
        }
    }
}
