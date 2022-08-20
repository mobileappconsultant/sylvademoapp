package com.sylval.demo.android.utils

private const val EMAIL_MESSAGE = "Invalid email address"
private const val REQUIRED_MESSAGE = "This field is required"
private const val INVALID_PASSWORD = "Please enter a strong password. Passwords must contain at least \n- 8 characters\n- 1 lower case\n- 1 uppercase\n- 1 special character\n- 1 number"

sealed interface Validator
open class Email(var message: String = EMAIL_MESSAGE) : Validator
open class Required(var message: String = REQUIRED_MESSAGE) : Validator
open class Password(var message: String = INVALID_PASSWORD) : Validator
