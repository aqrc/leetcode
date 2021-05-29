import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLongestSubstringTest {
    @Test
    fun test1() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("mabcm")
        assertEquals(4, len)
    }

    @Test
    fun test2() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("abmabcm")
        assertEquals(4, len)
    }

    @Test
    fun test3() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("mabcmabcd")
        assertEquals(5, len)
    }

    @Test
    fun test4() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("abcdaabcd")
        assertEquals(4, len)
    }

    @Test
    fun test5() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("abacdadabcd")
        assertEquals(4, len)
    }

    @Test
    fun test6() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew")
        assertEquals(3, len)
    }

    @Test
    fun test7() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("pp")
        assertEquals(1, len)
    }

    @Test
    fun test8() {
        val len = LengthOfLongestSubstring().lengthOfLongestSubstring("ppww")
        assertEquals(2, len)
    }
}