package task146.lruCache

class LRUCacheUsingLinkedHashMap(private val capacity: Int) {
    private val cache = LinkedHashMap<Int, Int>(capacity, 0.75f, true)

    fun get(key: Int): Int {
        return cache[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if (cache.size == capacity && !cache.containsKey(key)) {
            cache.remove(cache.keys.first())
        }

        cache[key] = value
    }
}