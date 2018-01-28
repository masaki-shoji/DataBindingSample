package com.badlogic.masaki.databindingpractice

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * Created by shojimasaki on 2018/01/28.
 */
@RunWith(Enclosed::class)
class UserTest {
    class CaseThatTheOtherFieldIsNull {
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
            assertThat(mSut?.firstName).isEqualTo(expected)
            assertThat(mSut?.lastName).isNull()
        }

        @Test
        @Throws(Exception::class)
        fun testUserLastName() {
            val expected = "lastName"
            mSut?.lastName = "lastName"
            assertThat(mSut?.firstName).isNull()
            assertThat(mSut?.lastName).isEqualTo(expected)
        }
    }

    class CaseThatAllTheFieldsIsNotNull {
        private var mSut: User? = null

        @Before
        @Throws(Exception::class)
        fun setUp() {
            mSut = User("firstName", "lastName")
        }

        @After
        @Throws(Exception::class)
        fun tearDown() {
            mSut = null
        }

        @Test
        @Throws(Exception::class)
        fun testUser() {
            val expectedUser = User(firstName = "firstName", lastName = "lastName")
            assertThat(mSut?.firstName).isEqualTo(expectedUser.firstName)
            assertThat(mSut?.lastName).isEqualTo(expectedUser.lastName)
        }
    }

    class CaseThatAllTheFieldsIsNull {
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
        fun testUser() {
            assertThat(mSut?.firstName).isNull()
            assertThat(mSut?.lastName).isNull()
        }
    }
}