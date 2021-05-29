import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {
    @Test
    fun test() {
        val l1 = ListNode(9).apply { this.next = ListNode(9).apply { this.next = ListNode(9) } }
        val l2 = ListNode(9).apply { this.next = ListNode(9).apply { this.next = ListNode(9) } }

        val result = AddTwoNumbers().addTwoNumbers(l1, l2)

        assertEquals(8, result?.`val`)
        assertEquals(9, result?.next?.`val`)
        assertEquals(9, result?.next?.next?.`val`)
        assertEquals(1, result?.next?.next?.next?.`val`)
    }
}