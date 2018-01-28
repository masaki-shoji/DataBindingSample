package com.badlogic.masaki.databindingpractice

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by shojimasaki on 2018/01/28.
 */
class UserTest {
    private var mSut: User? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mSut = User()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        mSut = null
    }

    @Test
    @Throws(Exception::class)
    fun testUserFirstName() {
        val expected = "firstName"
        mSut?.firstName = "firstName"
        assertThat(mSut?.firstName, `is`(expected))
    }

    @Test
    @Throws(Exception::class)
    fun testUserLastName() {
        val expected = "lastName"
        mSut?.lastName = "lastName"
        assertThat(mSut?.lastName, `is`(expected))
    }
}