package task21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeTwoSortedLists21Test {
    @Test
    fun example1() {
        val list1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
        val list2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
        assertEquals("1,1,2,3,4,4", MergeTwoSortedLists21().mergeTwoLists(list1, list2).toString())
    }

    @Test
    fun example2() {
        assertEquals("null", MergeTwoSortedLists21().mergeTwoLists(null, null).toString())
    }

    @Test
    fun example3() {
        val list2 = ListNode(0)
        assertEquals("0", MergeTwoSortedLists21().mergeTwoLists(null, list2).toString())
    }
}