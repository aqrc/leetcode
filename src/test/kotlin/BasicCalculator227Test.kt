import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCalculator227Test {
    @Test
    fun example1() = assertEquals(7, BasicCalculator227().calculate("3+2*2"))

    @Test
    fun example2() = assertEquals(1, BasicCalculator227().calculate(" 3/2 "))

    @Test
    fun example3() = assertEquals(5, BasicCalculator227().calculate(" 3+5 / 2 "))

    @Test
    fun test1() = assertEquals(17, BasicCalculator227().calculate("3 * 5 + 2"))

    @Test
    fun test2() = assertEquals(18, BasicCalculator227().calculate("1 + 3 * 5 + 2"))

    @Test
    fun test3() = assertEquals(22, BasicCalculator227().calculate("4 * 3 + 5 * 2"))

    @Test
    fun test4() = assertEquals(10, BasicCalculator227().calculate(" 9 - 6 / 3 + 5 * 2 - 7"))

    @Test
    fun test5() = assertEquals(890, BasicCalculator227().calculate(" 900 - 500 / 50"))

    @Test
    fun test6() = assertEquals(0, BasicCalculator227().calculate("0"))

    @Test
    fun test93() = assertEquals(6, BasicCalculator227().calculate("1+2*5/3+6/4*2"))

    @Test
    fun test54() = assertEquals(3, BasicCalculator227().calculate("1+1+1"))
}