import org.junit.jupiter.api.Test

class PermutationsTest {
    @Test
    fun test1() {
        val permutations = Permutations().permute(arrayListOf(1, 2).toIntArray())
        print(permutations)
    }

    @Test
    fun test2() {
        val permutations = Permutations().permute(arrayListOf(1, 2, 3).toIntArray())
        print(permutations)
    }

    @Test
    fun test3() {
        val permutations = Permutations().permute(arrayListOf(1, 2, 3, 4).toIntArray())
        print(permutations)
    }
}