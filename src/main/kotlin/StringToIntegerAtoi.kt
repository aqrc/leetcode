class StringToIntegerAtoi {
    fun myAtoi(s: String): Int {
        var isNegative: Boolean? = null
        return s.asSequence()
            .dropWhile { it == ' ' }
            .dropWhile { (it == '+' && isNegative == null).also { wasPlus -> if (wasPlus) isNegative = false} }
            .dropWhile { (it == '-' && isNegative == null).also { wasMinus -> if (wasMinus) isNegative = true} }
            .takeWhile {
                it in listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
            }
            .joinToString("")
            .takeIf { it.isNotEmpty() }
            ?.let { numberAsString ->
                runCatching {
                    numberAsString
                        .let {
                            if (isNegative == true) "-$numberAsString"
                            else numberAsString
                        }
                        .toInt()
                }.getOrElse {
                    if (isNegative == true)
                        Int.MIN_VALUE
                    else Int.MAX_VALUE
                }
            }
            ?: 0
    }
}