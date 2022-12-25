package task21

class MergeTwoSortedLists21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var currentList1Node = list1
        var currentList2Node = list2

        val mergedListHead: ListNode = if (list1.`val` < list2.`val`) {
            list1.also { currentList1Node = list1.next }
        } else {
            list2.also { currentList2Node = list2.next }
        }

        var currentMergedListNode = mergedListHead


        while (currentList1Node != null && currentList2Node != null) {
            currentMergedListNode.next =
                if (currentList1Node!!.`val` < currentList2Node!!.`val`)
                    currentList1Node.also { currentList1Node = currentList1Node!!.next }
                else currentList2Node.also { currentList2Node = currentList2Node!!.next }

            currentMergedListNode = currentMergedListNode.next!!
        }

        if (currentList1Node == null) currentMergedListNode.next = currentList2Node
        if (currentList2Node == null) currentMergedListNode.next = currentList1Node

        return mergedListHead
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        var node: ListNode? = this
        val vals = mutableListOf<Int>()
        while (node != null) {
            vals.add(node.`val`)
            node = node.next
        }
        return vals.joinToString(",")
    }
}