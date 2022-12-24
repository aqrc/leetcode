class LongestIncreasingSubsequence300DP {
    fun lengthOfLIS(nums: IntArray): Int {
        val longestSequence = IntArray(nums.size)
        var arrayEnd = 0

        for (num in nums) {
            var position = longestSequence.binarySearch(num, 0, arrayEnd)
            if (position < 0) position = -(position + 1)
            longestSequence[position] = num
            if (arrayEnd == position) arrayEnd++
        }

        return arrayEnd
    }
}