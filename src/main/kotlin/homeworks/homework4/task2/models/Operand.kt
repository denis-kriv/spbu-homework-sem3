package homeworks.homework4.task2.models

import homeworks.homework4.task2.models.interfaces.TreeItem

class Operand(private val value: Int): TreeItem {

    override fun toInt(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }
}
