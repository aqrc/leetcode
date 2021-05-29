class ReverseInteger {
    fun reverse(x: Int): Int {
        val strX = if (x < 0) (-x).toString() else x

        return strX.toString()
            .reversed()
            .let { xStrRev ->
                runCatching { xStrRev.toInt() }
                    .getOrElse { 0 }
            }
            .let { if (x < 0) -it else it }
    }
}