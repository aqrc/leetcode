class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val uniqueCharPositions = hashMapOf<Char, Int>()
        var maxSubstringLen = 0
        var currentSubstringLen = 0

        s.forEachIndexed { i, char ->
            uniqueCharPositions[char]
                ?.takeIf { oldIndex -> oldIndex + currentSubstringLen >= i }
                ?.let { oldIndex -> currentSubstringLen = (i - oldIndex) - 1 }

            currentSubstringLen++
            uniqueCharPositions[char] = i
            if (maxSubstringLen < currentSubstringLen) maxSubstringLen = currentSubstringLen
        }

        return maxSubstringLen
    }
}