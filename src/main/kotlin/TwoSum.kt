import java.lang.IllegalArgumentException

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIndex = hashMapOf<Int, Int>()

        nums.forEachIndexed { firstIndex, firstPart ->
            numToIndex[target - firstPart]?.let { secondIndex -> return intArrayOf(firstIndex, secondIndex) }
            numToIndex[firstPart] = firstIndex
        }

        throw Exception("Incorrect input")
    }
}