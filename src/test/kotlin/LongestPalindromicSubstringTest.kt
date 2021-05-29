import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromicSubstringTest {
    private val palindromService = LongestPalindromicSubstring()

    @Test
    fun example1() {
        val result = palindromService.longestPalindrome("babad")
        assertEquals("bab", result)
    }

    @Test
    fun example2() {
        val result = palindromService.longestPalindrome("cbbd")
        assertEquals("bb", result)
    }

    @Test
    fun example3() {
        val result = palindromService.longestPalindrome("a")
        assertEquals("a", result)
    }

    @Test
    fun example4() {
        val result = palindromService.longestPalindrome("ac")
        assertEquals("a", result)
    }


    @Test
    fun test1() {
        val result = palindromService.longestPalindrome("ccc")
        assertEquals("ccc", result)
    }

    @Test
    fun test2() {
        val result = palindromService.longestPalindrome("bb")
        assertEquals("bb", result)
    }


}