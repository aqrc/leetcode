import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringToIntegerAtoiTest {
    private val atoi = StringToIntegerAtoi()

    @Test
    fun example1() {
        val result = atoi.myAtoi("42")
        assertEquals(42, result)
    }

    @Test
    fun example2() {
        val result = atoi.myAtoi("   -42")
        assertEquals(-42, result)
    }

    @Test
    fun example3() {
        val result = atoi.myAtoi("4193 with words")
        assertEquals(4193, result)
    }

    @Test
    fun example4() {
        val result = atoi.myAtoi("words and 987")
        assertEquals(0, result)
    }

    @Test
    fun example5() {
        val result = atoi.myAtoi("-91283472332")
        assertEquals(-2147483648, result)
    }

    @Test
    fun test1() {
        val result = atoi.myAtoi("-+12")
        assertEquals(0, result)
    }

    @Test
    fun test2() {
        val result = atoi.myAtoi("+1")
        assertEquals(1, result)
    }

    @Test
    fun test3() {
        val result = atoi.myAtoi("+-12")
        assertEquals(0, result)
    }

    @Test
    fun test4() {
        assertEquals(0, '0'.toInt() - 48)
        assertEquals(9, '9'.toInt() - 48)

    }

    @Test
    fun test5() {
        val result = atoi.myAtoi("")
        assertEquals(0, result)
    }

    @Test
    fun test6() {
        val result = atoi.myAtoi(" ")
        assertEquals(0, result)
    }
}