import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidParentheses20Test {
    @Test
    fun example1() = assertTrue(ValidParentheses20().isValid("()"))

    @Test
    fun example2() = assertTrue(ValidParentheses20().isValid("()[]{}"))

    @Test
    fun example3() = assertFalse(ValidParentheses20().isValid("(]"))
}