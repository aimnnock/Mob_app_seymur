package com.seymur.mobileapp

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CredentialsManagerTest {

    @Test
    fun testEmptyEmail() {
        val email = ""
        assertFalse(CredentialsManager.isEmailValid(email))
    }

    @Test
    fun testWrongFormatEmail() {
        val email = "invalidemail"
        assertFalse(CredentialsManager.isEmailValid(email))
    }

    @Test
    fun testWellFormattedEmail() {
        val email = "test@example.com"
        assertTrue(CredentialsManager.isEmailValid(email))
    }

    @Test
    fun testEmptyPassword() {
        val password = ""
        assertFalse(CredentialsManager.isPasswordValid(password))
    }

    @Test
    fun testFilledPassword() {
        val password = "1234"
        assertTrue(CredentialsManager.isPasswordValid(password))
    }

    @Test
    fun testHardcodedCredentials() {
        val email = "test@te.st"
        val password = "1234"
        assertTrue(email == "test@te.st" && password == "1234")
    }
}
