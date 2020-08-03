package homeworks.homework4.task1

import homeworks.homework4.task1.enums.HashModules
import homeworks.homework4.task1.interfaces.IHashTable
import java.io.File
import java.lang.IllegalArgumentException
import java.util.NoSuchElementException

private fun getSize(table: HashTable): String {
    return table.items.size.toString()
}

private fun getConflicts(table: HashTable): String {
    var conflicts = 0
    table.items.forEach {
        if (it.size > 1) conflicts++
    }
    return conflicts.toString()
}

private fun getMaxLength(table: HashTable): String {
    var maxLength = 0
    table.items.forEach {
        if (it.size > maxLength) maxLength = it.size
    }
    return maxLength.toString()
}

private fun getLoadFactor(table: HashTable): String {
    return (table.items.size / table.itemsQuantity).toString()
}

private fun updateItems(table: HashTable): Array<MutableList<String>> {
    val updatedItems: Array<MutableList<String>> = arrayOf()
    table.items.forEach {
        it.forEach {
            updatedItems[table.hashFunction.getHash(it)].add(it)
        }
    }
    return updatedItems
}

class HashTable : IHashTable {

    var items = Array<MutableList<String>>(2048) { mutableListOf() }
    var hashFunction = HashFunctions(HashModules.HASH3)
    var itemsQuantity = 0

    override fun plus(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")

        for (it in items[hashFunction.getHash(value)]) {
            if (it == value) {
                throw CloneNotSupportedException("Element is already exist.")
            }
        }

        items[hashFunction.getHash(value)].add(value)
        itemsQuantity++
    }

    override fun minus(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")

        var isExist = false

        for (it in items[hashFunction.getHash(value)]) {
            if (it == value) {
                isExist = true
                break
            }
        }

        if (isExist) {
            items[hashFunction.getHash(value)].remove(value)
            itemsQuantity--
        } else {
            throw NoSuchElementException("Element is not exist.")
        }
    }

    override fun getIndex(value: String?): Int {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")

        items[hashFunction.getHash(value)].forEach {
            if (it == value) return hashFunction.getHash(value)
        }

        throw NoSuchElementException("Element is not exist.")
    }

    override fun getStatistics(): List<String> {
        return listOf(getSize(this), getConflicts(this), getMaxLength(this), getLoadFactor(this))
    }

    override fun plusFromFile(fileName: String?) {
        if (fileName.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")

        val file = File(fileName)
        if (!file.exists()) throw NoSuchFileException(file, null, "File is not exist")

        file.forEachLine {
            items[hashFunction.getHash(it)].add(it)
            itemsQuantity++
        }
    }

    override fun chooseHashFunction(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")
        try {
            hashFunction = HashFunctions(HashModules.valueOf(value))
            items = updateItems(this)
        } catch (exception: IllegalArgumentException) {
            throw IllegalArgumentException("String is not correct.")
        }
    }
}
