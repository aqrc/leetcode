package task146.lruCache

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LRUCacheUsingLinkedHashMapTest {
    @Test
    fun example() {
        val lRUCache = LRUCacheUsingLinkedHashMap(2)
        lRUCache.put(1, 1) // cache is {1=1}
        lRUCache.put(2, 2) // cache is {1=1, 2=2}
        assertEquals(1, lRUCache.get(1))
        lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertEquals(-1, lRUCache.get(2))
        lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertEquals(-1, lRUCache.get(1))
        assertEquals(3, lRUCache.get(3))
        assertEquals(4, lRUCache.get(4))
    }
}