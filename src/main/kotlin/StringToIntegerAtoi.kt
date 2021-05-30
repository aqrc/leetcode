class StringToIntegerAtoi {
    fun myAtoi(s: String): Int {
        if (s.isEmpty()) return 0

        var index = 0
        while (index < s.length && s[index] == ' ') {
            index++
        }

        if (index >= s.length) return 0


        val isNegative = when (s[index]) {
            '-' -> {
                index++
                true
            }
            '+' -> {
                index++
                false
            }
            else -> false
        }

        var result = 0
        while (index < s.length && s[index] in '0'..'9') {
            val nextUnit = s[index].toInt() - 48
            if (isNegative ) {
                if ((Int.MAX_VALUE - nextUnit) / 10 < result) return Int.MIN_VALUE
            }
            else if ((Int.MAX_VALUE - nextUnit) / 10 < result) return Int.MAX_VALUE
            result = result * 10 + nextUnit
            index++
        }

        return if (isNegative) -result else result
    }
}