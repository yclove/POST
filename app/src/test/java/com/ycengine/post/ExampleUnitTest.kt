package com.ycengine.post

import dalvik.annotation.TestTarget
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private var intVal: Int = 0

    @Before
    fun init() {
        intVal++
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private fun printResult(body: (Int, Int) -> Int) {
        println(body(5, 7))
    }

    private fun sum(a: Int, b: Int) = a + b
    private fun minus(a: Int, b: Int) = a - b

    @Test
    fun printCall() {
        printResult({a, b -> b})
        printResult(::sum)
        printResult(::minus)

        assertEquals(4, 2 + 2)
    }
}
