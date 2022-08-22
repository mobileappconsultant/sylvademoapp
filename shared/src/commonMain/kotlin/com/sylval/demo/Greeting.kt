package com.sylval.demo

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
