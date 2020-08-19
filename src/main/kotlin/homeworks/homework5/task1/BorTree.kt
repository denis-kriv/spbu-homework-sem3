package homeworks.homework5.task1

import homeworks.homework5.task1.interfaces.IBorTree
import homeworks.homework5.task1.models.TreeItem
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.io.Serializable
import java.util.Scanner

private fun plus(item: TreeItem, element: String): Boolean {
    if (element == item.value) {
        if (!item.isTerminal) item.size++

        val isExist = item.isTerminal
        item.isTerminal = true

        return !isExist
    }

    var currentItem: TreeItem? = null
    val index = if (item.value == "") 0 else 1

    for (i in item.children) {
        if (i.value == element[index].toString()) {
            currentItem = i
            break
        }
    }

    if (currentItem == null) {
        currentItem = TreeItem(element[index].toString())
        item.children.add(currentItem)
    }

    val result = plus(currentItem, element.substring(index))
    if (result) item.size++

    return result
}

private fun isExist(item: TreeItem, element: String): Boolean {
    if (item.value == element) return item.isTerminal

    var result = false
    val index = if (item.value == "") 0 else 1

    for (i in item.children) {
        if (i.value == element[index].toString()) result = isExist(i, element.substring(index))
    }

    return result
}

private fun minus(item: TreeItem, element: String): Boolean {
    if (item.value == element) {
        if (item.isTerminal) item.size--

        val isExist = item.isTerminal
        item.isTerminal = false

        return isExist
    }

    var currentItem: TreeItem? = null
    val index = if (item.value == "") 0 else 1

    for (i in item.children) {
        if (i.value == element[index].toString()) {
            currentItem = i
            break
        }
    }

    return if (currentItem != null) {
        val result = minus(currentItem, element.substring(index))
        if (result) item.size--

        result
    } else false
}

private fun quantityWithThisPrefix(item: TreeItem, prefix: String): Int {
    if (prefix == item.value) {
        return item.size
    }

    var currentItem: TreeItem? = null
    val index = if (item.value == "") 0 else 1

    for (i in item.children) {
        if (i.value == prefix[index].toString()) {
            currentItem = i
            break
        }
    }

    return if (currentItem == null) 0 else quantityWithThisPrefix(currentItem, prefix.substring(index))
}

private fun getAllWords(item: TreeItem, prefix: String): MutableList<String> {
    val result = if (item.isTerminal) mutableListOf("$prefix${item.value}") else mutableListOf()

    item.children.forEach {
        result.addAll(getAllWords(it, "$prefix${item.value}"))
    }

    return result
}

class BorTree : IBorTree, Serializable {

    private val head: TreeItem = TreeItem("")

    private fun clear() {
        head.children.clear()
        head.isTerminal = false
        head.size = 0
    }

    override fun add(element: String): Boolean {
        return plus(head, element)
    }

    override fun contains(element: String): Boolean {
        return isExist(head, element)
    }

    override fun remove(element: String): Boolean {
        return minus(head, element)
    }

    override fun size(): Int {
        return head.size
    }

    override fun howManyStartWithPrefix(prefix: String): Int {
        return quantityWithThisPrefix(head, prefix)
    }

    fun serialize(output: OutputStream) {
        val words = getAllWords(head, "")

        if (words.isEmpty()) throw IOException("Tree is empty.")

        output.write((words.joinToString(" ") { "'$it'" }).toByteArray())
        output.close()
    }

    fun deserialize(input: InputStream) {
        val inputString = input.bufferedReader().readLine() ?: throw KotlinNullPointerException("Input is null.")
        val scanner = Scanner(inputString)

        clear()

        while (scanner.hasNext()) {
            val word = scanner.next()

            if (word.length < 2 || word[0] != '\'' || word[word.lastIndex] != '\'') {
                throw IOException("String is not correct.")
            }

            if (word.length == 2) {
                add("")
                continue
            }

            add(word.substring(1, word.lastIndex))
        }

        input.close()
    }
}
