package task146.lruCache

import java.util.HashMap

class LRUCacheCustom(capacity: Int) {
    private val hashMap = HashMap<Int, CustomListNode2>()
    private val linkedList = CustomLinkedList2(capacity)

    fun get(key: Int): Int {
        return hashMap[key]?.also { linkedList.moveOnTop(it) }?.value ?: -1
    }


    fun put(key: Int, value: Int) {
        val keyExists = hashMap.containsKey(key)

        if (keyExists) {
            hashMap[key]!!.value = value
            linkedList.moveOnTop(hashMap[key]!!)
            return
        }

        if (linkedList.isFull()) {
            hashMap.remove(
                linkedList.removeTail()
            )
        }

        val node = CustomListNode2(key, value, null, null)
        linkedList.add(node)
        hashMap[key] = node
    }
}

private class CustomLinkedList2(val capacity: Int) {
    var size: Int = 0
    private var head: CustomListNode2? = null
    private var tail: CustomListNode2? = null

    fun isFull(): Boolean {
        return size >= capacity
    }

    fun add(node: CustomListNode2) {
        if (head == null || capacity == 1) {
            head = node
            tail = node
        } else {
            if (size == 1) {
                tail = head
            }
            head!!.prev = node
            node.next = head
            head = node
        }
        size++
    }

    fun removeTail(): Int {
        val tailKey: Int
        if (capacity == 1) {
            tailKey = tail!!.key
            head = null
            tail = null
        } else {
            tailKey = tail!!.key
            tail = tail!!.prev!!
            tail!!.next = null
        }

        if (size == 1) {
            head = tail
        }

        size--

        return tailKey
    }

    fun moveOnTop(node: CustomListNode2) {
        if (capacity == 1 || size == 1 || node == head) return

        if (node == tail) {
            tail = node.prev
        } else {
            node.next!!.prev = node.prev
        }
        node.prev!!.next = node.next
        node.prev = null
        node.next = null
        size--
        add(node)
    }
}

private class CustomListNode2(
    var key: Int,
    var value: Int,
    var prev: CustomListNode2?,
    var next: CustomListNode2?
)