import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {
    private val solution = MedianOfTwoSortedArrays()

    @Test
    fun example1() {
        val median = solution.findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2))
        assertEquals(2.00000, median)
    }

    @Test
    fun example2() {
        val median = solution.findMedianSortedArrays(intArrayOf(1,2), intArrayOf(3,4))
        assertEquals(2.50000, median)
    }

    @Test
    fun example3() {
        val median = solution.findMedianSortedArrays(intArrayOf(0,0), intArrayOf(0,0))
        assertEquals(0.00000, median)
    }

    @Test
    fun example4() {
        val median = solution.findMedianSortedArrays(intArrayOf(), intArrayOf(1))
        assertEquals(1.00000, median)
    }

    @Test
    fun example5() {
        val median = solution.findMedianSortedArrays(intArrayOf(2), intArrayOf())
        assertEquals(2.00000, median)
    }

    @Test
    fun test1() {
        val median = solution.findMedianSortedArrays(intArrayOf(2,2,2,2,2,2), intArrayOf(5,5,5,5))
        assertEquals(2.00000, median)
    }

    @Test
    fun test2() {
        val median = solution.findMedianSortedArrays(intArrayOf(1,3,5,7), intArrayOf(2,4,6,8))
        assertEquals(4.50000, median)
    }

    @Test
    fun test3() {
        val median = solution.findMedianSortedArrays(intArrayOf(2,5,5,5,5), intArrayOf(5,5,5,5))
        assertEquals(5.00000, median)
    }

    @Test
    fun test4() {
        val median = solution.findMedianSortedArrays(intArrayOf(1,1,1), intArrayOf(100,100))
        assertEquals(1.00000, median)
    }

    @Test
    fun test5() {
        val median = solution.findMedianSortedArrays(intArrayOf(100,100), intArrayOf(1,1,1))
        assertEquals(1.00000, median)
    }
}