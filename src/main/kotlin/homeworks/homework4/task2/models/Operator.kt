package homeworks.homework4.task2.models

import homeworks.homework4.task2.models.interfaces.TreeItem

enum class Operators(val value: String) {
    Addition("+"),
    Subtraction("-"),
    Multiplying("*"),
    Dividing("/")
}

class Operator(private val type: Operators,
               private val leftChild: TreeItem,
               private val rightChild: TreeItem) : TreeItem {

    override fun toInt(): Int {
        return when (type) {
            Operators.Addition -> leftChild.toInt() + rightChild.toInt()
            Operators.Subtraction -> leftChild.toInt() - rightChild.toInt()
            Operators.Multiplying -> leftChild.toInt() * rightChild.toInt()
            Operators.Dividing -> leftChild.toInt() / rightChild.toInt()
        }
    }

    override fun toString(): String {
        return "(${type.value} $leftChild $rightChild)"
    }
}
