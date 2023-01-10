package task146.lruCache

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LRUCacheCustomTest {

    @Test
    fun example() {
        val lRUCache = LRUCacheCustom(2)
        lRUCache.put(1, 1) // cache is {1=1}
        lRUCache.put(2, 2) // cache is {1=1, 2=2}
        Assertions.assertEquals(1, lRUCache.get(1))
        lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        Assertions.assertEquals(-1, lRUCache.get(2))
        lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        Assertions.assertEquals(-1, lRUCache.get(1))
        Assertions.assertEquals(3, lRUCache.get(3))
        Assertions.assertEquals(4, lRUCache.get(4))
    }

    //["LRUCache","put","get","put","get","get"]
    //[[1],[2,1],[2],[3,2],[2],[3]]
    @Test
    fun test6() {
        val lRUCache = LRUCacheCustom(1)
        lRUCache.put(2, 1)
        Assertions.assertEquals(1, lRUCache.get(2))
        lRUCache.put(3, 2) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        Assertions.assertEquals(-1, lRUCache.get(2))
        Assertions.assertEquals(2, lRUCache.get(3))
    }

    //["LRUCache","put","put","get","put","put","get"]
    //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
    @Test
    fun test7() {
        val lRUCache = LRUCacheCustom(2)
        lRUCache.put(2, 1)
        lRUCache.put(2, 2)
        Assertions.assertEquals(2, lRUCache.get(2))
        lRUCache.put(1, 1)
        lRUCache.put(4, 1)
        Assertions.assertEquals(-1, lRUCache.get(2))
    }

    //["LRUCache","get","put","get","put","put","get","get"]
    //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    @Test
    fun test10() {
        val lRUCache = LRUCacheCustom(2)
        Assertions.assertEquals(-1, lRUCache.get(2))
        lRUCache.put(2, 6)
        Assertions.assertEquals(-1, lRUCache.get(1))
        lRUCache.put(1, 5)
        lRUCache.put(1, 2)
        Assertions.assertEquals(2, lRUCache.get(1))
        Assertions.assertEquals(6, lRUCache.get(2))
    }

    //["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
    //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    @Test
    fun test12() {
        val lRUCache = LRUCacheCustom(3)
        lRUCache.put(1, 1)
        lRUCache.put(2, 2)
        lRUCache.put(3, 3)
        lRUCache.put(4, 4)
        Assertions.assertEquals(4, lRUCache.get(4))
        Assertions.assertEquals(3, lRUCache.get(3))
        Assertions.assertEquals(2, lRUCache.get(2))
        Assertions.assertEquals(-1, lRUCache.get(1))
        lRUCache.put(5, 5)
        Assertions.assertEquals(-1, lRUCache.get(1))
        Assertions.assertEquals(2, lRUCache.get(2))
        Assertions.assertEquals(3, lRUCache.get(3))
        Assertions.assertEquals(-1, lRUCache.get(4))
        Assertions.assertEquals(5, lRUCache.get(5))
    }
}