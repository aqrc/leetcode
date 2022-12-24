import java.lang.RuntimeException

/**
 * An attempt to make the solution both in competitive and OOP ways, so something in the middle it is
 */
class BasicCalculator227 {

    fun calculate(s: String): Int {
        val tree = ExpressionTree()

        var index = 0
        do {
            val token: ParsedToken
            readToken(s, index).let { tokenAndIndex ->
                token = tokenAndIndex.first
                index = tokenAndIndex.second
            }

            when (token) {
                is Number -> tree.appendValue(Value(token.value))
                is Operator -> tree.appendOperator(token.type)
                Space -> {}
            }

//            tree.printTree()
        }
        while(index < s.length)

        return tree.eval()
    }

    private fun readToken(s: String, index: Int): Pair<ParsedToken, Int> {
        var number = 0
        var recentState = State.INITIAL

        for (i in index until s.length) {
            val char = s[i]
            when (val parsedToken = char.parseWithCategory()) {
                is Number -> {
                    when (recentState) {
                        State.INITIAL,
                        State.READING_NUMBER -> number = number.appendDigit(parsedToken.value)
                    }
                    recentState = State.READING_NUMBER
                }
                is Operator -> return when (recentState) {
                    State.INITIAL -> Pair(parsedToken, i + 1)
                    State.READING_NUMBER -> Pair(Number(number), i)
                }
                is Space -> {}
            }
        }

        // end of string
        return Pair(Number(number), s.length)
    }

    private enum class State { INITIAL, READING_NUMBER }

    private fun Int.appendDigit(digit: Int) = this * 10 + digit
    private fun Char.parseWithCategory(): ParsedToken {
        return when (this) {
            in '0'..'9' -> Number(this.minus('0'))
            '+' -> Operator(OperatorType.ADD)
            '-' -> Operator(OperatorType.SUB)
            '*' -> Operator(OperatorType.MULT)
            '/' -> Operator(OperatorType.DIV)
            ' ' -> Space
            else -> throw RuntimeException("Unexpected symbol: $this")
        }
    }
}

class ExpressionTree {
    private var root: Valuable? = null
    private var tail: Valuable? = root
    fun appendValue(v: Valuable) {
        if (root == null) {
            root = v
            tail = root
            return
        }

        val localTail = tail
        if (localTail is Expression) {
            if (localTail.operator == null) {
                localTail.leftExpression = v
                return
            }

            if (localTail.rightExpression == null) {
                localTail.rightExpression = v
                return
            }
        }

        throw RuntimeException("Invalid input")
    }

    fun appendOperator(operatorType: OperatorType) {
        if (tail is Value) {
            tail = Expression(tail, operatorType, null)
            root = tail
            return
        }

        val localTail = tail
        if (localTail is Expression) {
            if (localTail.operator == null) {
                localTail.operator = operatorType
                return
            }

            if (operatorType.priority == localTail.operator!!.priority) {
                val rootIsTail = root == tail
                tail = Expression(tail, operatorType, null)
                if (rootIsTail) root = tail
                else (root as Expression).rightExpression = tail
            }
            else if (operatorType.priority > localTail.operator!!.priority) {
                val newTail = Expression(localTail.rightExpression, operatorType, null)
                localTail.rightExpression = newTail
                tail = newTail
            } else {
                root = Expression(root, operatorType, null)
                tail = root
            }
        }
    }

    fun eval(): Int {
        return root?.getValue() ?: 0
    }

    fun printTree() {
        println(valuableToString(root))
    }

    private fun valuableToString(valuable: Valuable?): String {
        if (valuable is Value) return valuable.getValue().toString()
        if (valuable is Expression) {
            return String.format(
                "(%s %s %s)",
                valuableToString(valuable.leftExpression),
                valuable.operator,
                valuableToString(valuable.rightExpression)
            )
        }
        return "NULL"
    }
}

sealed class ParsedToken
class Number(val value: Int) : ParsedToken()
class Operator(val type: OperatorType) : ParsedToken()
enum class OperatorType(val priority: Int) {
    ADD(1), SUB(1), MULT(2), DIV(2),
}
object Space : ParsedToken()


interface Valuable {
    fun getValue(): Int
}
class Expression(
    var leftExpression: Valuable?,
    var operator: OperatorType?,
    var rightExpression: Valuable?
) : Valuable {
    override fun getValue(): Int {
        val left = leftExpression?.getValue() ?: 0
        val right = rightExpression?.getValue() ?: 0
        println("$left $operator $right")
        return when (operator) {
            OperatorType.ADD -> left + right
            OperatorType.SUB -> left - right
            OperatorType.MULT -> left * right
            OperatorType.DIV -> left / right
            null -> throw RuntimeException("Operator is null")
        }
    }


}
class Value(private val value: Int) : Valuable {
    override fun getValue(): Int = value
}