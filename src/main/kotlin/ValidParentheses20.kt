import java.util.Stack

class ValidParentheses20 {
    private val openingToClosingBracketsMap = mapOf('(' to ')', '[' to ']', '{' to '}')

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (bracket in s) {
            if (bracket.isOpeningBracket()) {
                stack.push(bracket)
                continue
            }

            if (stack.isEmpty()) return false


            if (bracket == openingToClosingBracketsMap[stack.peek()]) {
                stack.pop()
                continue
            }

            return false
        }

        return stack.isEmpty()
    }

    private fun Char.isOpeningBracket(): Boolean = this in openingToClosingBracketsMap.keys
}