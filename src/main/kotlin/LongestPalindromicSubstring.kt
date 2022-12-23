class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var longestPalStart = 0
        var longestPalLength = 1

        for (i in s.indices) {
            s.findLongestPalindromicAround(i).let { len ->
                if (len > longestPalLength) {
                    longestPalStart = i - (len shr 1)
                    longestPalLength = len
                }
            }

            if (i + 1 < s.length && s[i] == s[i + 1]) {
                s.findLongestPalindromicAround(i, true).let { len ->
                    if (len > longestPalLength) {
                        longestPalStart = i - (len shr 1) + 1
                        longestPalLength = len
                    }
                }
            }
        }

        return s.substring(longestPalStart, longestPalStart + longestPalLength)
    }

    private fun String.findLongestPalindromicAround(startIndex: Int, isStartCoupled: Boolean = false): Int {
        var currentLeft = startIndex - 1
        var currentRight = if (isStartCoupled) startIndex + 2 else startIndex + 1
        while (0 <= currentLeft && currentRight < this.length) {
            if (this[currentLeft] == this[currentRight]) {
                currentLeft--
                currentRight++
            } else {
                break
            }
        }
        return currentRight - currentLeft - 1
    }
}