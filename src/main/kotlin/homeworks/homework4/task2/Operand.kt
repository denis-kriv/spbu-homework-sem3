package homeworks.homework4.task2

class Operand(private val value: Int): TreeItem {

    override fun toInt(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }

    override fun asLine(): String {
        return value.toString()
    }

    override fun asTree(): List<String> {
        return listOf(value.toString())
    }
}
