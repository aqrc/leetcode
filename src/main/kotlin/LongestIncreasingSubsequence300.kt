/**
 * Attempt to solve it in ~O(N). Doesn't work on complex cases.
 */
class LongestIncreasingSubsequence300 {
    fun lengthOfLIS(nums: IntArray): Int {
        val counters = Counters()

        for (num in nums) {
            counters.check(num)
        }

        return counters.getMaxHeight()
    }
}

class Counters {
    private val counters: MutableList<Counter> = mutableListOf()

    fun check(num: Int) {
        if (counters.isEmpty()) {
            counters.add(Counter(num))
        } else {
            var newCounter: Counter? = null

            for (counter in counters) {
                if (newCounter == null && (counter.first > num && counter.height > 1 || counter.prevMinLast > num)) {
                    newCounter = Counter(num)
                }

                counter.check(num)
            }

            newCounter?.let(counters::add)
        }
    }

    fun getMaxHeight(): Int {
        var highestCounterIndex = 0
        var highestCounter = counters[0]
        for ((index, counter) in counters.withIndex()) {
            if (counter.height >= highestCounter.height) {
                highestCounterIndex = index
                highestCounter = counter
            }
        }

        var totalHeight = highestCounter.height
        var minFirst = highestCounter.first
        for (i in highestCounterIndex-1 downTo 0) {
            if (counters[i].first < minFirst) {
                minFirst = counters[i].first
                totalHeight++
            }
        }
        return totalHeight
    }
}

class Counter(var first: Int) {
    var minLast: Int = first
    var prevMinLast: Int = Int.MIN_VALUE
    var height = 1

    fun check(num: Int) {
        if (height == 1 && first > num) {
            first = num
            minLast = num
        } else if (first < num) {
            if (minLast < num) {
                prevMinLast = minLast
                minLast = num
                height++
            } else if (minLast > num) {
                if (prevMinLast < num) {
                    minLast = num
                }
            }
        }
    }
}
