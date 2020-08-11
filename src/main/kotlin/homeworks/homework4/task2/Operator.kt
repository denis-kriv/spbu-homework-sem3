package homeworks.homework4.task2

import java.lang.Exception

enum class Operators { Addition, Subtraction, Multiplying, Dividing }

class Operator(private val type: Operators, var leftChild: TreeItem?, var rightChild: TreeItem?): TreeItem {

    override fun toInt(): Int {
        if (leftChild == null || rightChild == null) throw Exception("Operator is null.")

        return when(type) {
            Operators.Addition -> leftChild!!.toInt() + rightChild!!.toInt()
            Operators.Subtraction -> leftChild!!.toInt() - rightChild!!.toInt()
            Operators.Multiplying -> leftChild!!.toInt() * rightChild!!.toInt()
            Operators.Dividing -> leftChild!!.toInt() / rightChild!!.toInt()
        }
    }

    override fun toString(): String {
        return when(type) {
            Operators.Addition -> "+"
            Operators.Subtraction -> "-"
            Operators.Multiplying -> "*"
            Operators.Dividing -> "/"
        }
    }

    override fun asLine(): String {

    }

    override fun asTree(): List<String> {

    }
}