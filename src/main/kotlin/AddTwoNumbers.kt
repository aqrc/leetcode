/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var first: ListNode? = l1 ?: return l2
        var second: ListNode? = l2 ?: return l1

        var currentResult: ListNode? = null
        val resultHead = ListNode (0)
        resultHead.next = currentResult
        var overflow = 0

        do {
            val sum = first.getVal() + second.getVal() + overflow
            overflow = sum / 10

            if (currentResult == null) {
                currentResult = ListNode(sum % 10)
                resultHead.next = currentResult
            } else {
                currentResult.next = ListNode(sum % 10)
                currentResult = currentResult.next
            }

            first = first?.next
            second = second?.next
        } while (first != null || second != null || overflow != 0)

        return resultHead.next
    }

    private inline fun ListNode?.getVal(): Int = this?.`val` ?: 0
}