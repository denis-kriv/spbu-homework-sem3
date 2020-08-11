package homeworks.homework4.task2

class Tree(val head: TreeItem) {

    fun read(string: String) {

    }

    fun printAsTree() {
        head.asTree().forEach {
            println(it)
        }
    }

    fun printAsLine() {
        println(head.asLine())
    }

    fun toInt(): Int {
        return head.toInt()
    }
}