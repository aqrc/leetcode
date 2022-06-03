class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.size == 1) return listOf(nums.asList())
        if (nums.size == 2) return nums.asList().let { listOf(it, it.reversed()) }
        return usingGraph(nums.toList())
            .map { it.toList() }
    }

    private fun usingGraph(nums: List<Int>): List<Set<Int>> {
        return findAllPathsAcrossGraph(nums, MutableList(nums.size) { false }, emptySet())
    }

    private fun findAllPathsAcrossGraph(
        nums: List<Int>,
        visitedList: List<Boolean>,
        permutation: Set<Int>
    ): List<Set<Int>> {
        var updated = false
        val permutations = nums.mapIndexedNotNull { numIndex, value ->
            if (visitedList[numIndex]) return@mapIndexedNotNull null

            updated = true
            val updatedPermutation = permutation.plus(value)
            val updatedVisitedList = visitedList.toMutableList().apply { this[numIndex] = true }
            return@mapIndexedNotNull findAllPathsAcrossGraph(nums, updatedVisitedList, updatedPermutation)
        }.flatten()

        return if (updated) permutations else listOf(permutation)
    }
}