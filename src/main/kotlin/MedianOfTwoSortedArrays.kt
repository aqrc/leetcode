class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        quick(nums1, nums2)?.let { return it }

        val size = nums1.size + nums2.size
        var counter1 = 0
        var counter2 = 0
        var last = 0
        var prevlast = 0

        while (counter1 + counter2 < size / 2 + 1) {
            if (counter1 < nums1.size
                && (counter2 >= nums2.size || nums1[counter1] <= nums2[counter2])) {
                prevlast = last
                last = nums1[counter1]
                counter1++
                continue
            }
            if (counter2 < nums2.size
                && (counter1 >= nums1.size || nums2[counter2] <= nums1[counter1])) {
                prevlast = last
                last = nums2[counter2]
                counter2++
                continue
            }
            break
        }

        if (size % 2 == 0) {
            return (prevlast + last).toDouble() / 2
        }

        return last.toDouble()

    }

    fun quick(nums1: IntArray, nums2: IntArray): Double? {
        val (leftNums, rightNums) = when {
            nums1.isEmpty() -> nums2 to null
            nums2.isEmpty() -> nums1 to null
            nums1[nums1.size-1] <= nums2[0] -> nums1 to nums2
            nums2[nums2.size-1] <= nums1[0] -> nums2 to nums1
            else -> return null
        }
        val lastIndex1 = leftNums.size - 1

        if (leftNums[lastIndex1] <= rightNums?.get(0) ?: 0) {
            val jointSize = leftNums.size + (rightNums?.size ?: 0)
            val jointLastIndex = jointSize - 1
            if (jointSize % 2 == 1) {
                val medianIndex = jointSize / 2
                return when (medianIndex) {
                    in 0..lastIndex1 -> leftNums[medianIndex].toDouble()
                    else -> rightNums?.get(medianIndex-lastIndex1-1)?.toDouble()
                }
            } else {
                val (medianIndex1, medianIndex2) = jointLastIndex / 2 to jointLastIndex / 2 + 1
                val median1 = when (medianIndex1) {
                    in 0..lastIndex1 -> leftNums[medianIndex1].toDouble()
                    else -> rightNums?.get(medianIndex1-lastIndex1-1)?.toDouble()
                }
                val median2 = when (medianIndex2) {
                    in 0..lastIndex1 -> leftNums[medianIndex2].toDouble()
                    else -> rightNums?.get(medianIndex2-lastIndex1-1)?.toDouble()
                }
                return ((median1 ?: 0.0) + (median2 ?: 0.0)) / 2
            }
        }
        return null
    }
}