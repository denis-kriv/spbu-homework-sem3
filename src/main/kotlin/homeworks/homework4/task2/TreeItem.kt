package homeworks.homework4.task2

interface TreeItem {
    fun toInt(): Int
    override fun toString(): String
    fun asLine(): String
    fun asTree(): List<String>
}