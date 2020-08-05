package homeworks.homework4.task1

import homeworks.homework4.task1.enums.HashKeys
import homeworks.homework4.task1.interfaces.IHashTable
import java.io.File
import java.lang.IllegalArgumentException
import java.util.NoSuchElementException
import homeworks.homework4.task1.models.Statistics
import kotlin.math.roundToInt

private fun getSize(table: HashTable): Int {
    return table.items.size
}

private fun getConflicts(table: HashTable): Int {
    var conflicts = 0
    table.items.forEach {
        if (it.size > 1) conflicts++
    }
    return conflicts
}

private fun getMaxLength(table: HashTable): Int {
    var maxLength = 0
    table.items.forEach {
        if (it.size > maxLength) maxLength = it.size
    }
    return maxLength
}

private fun getLoadFactor(table: HashTable): Double {
    val result = (table.itemsQuantity.toDouble() / table.items.size.toDouble())

    return (((result * Count.count).roundToInt().toDouble()) / Count.count)
}
private object Count {
    const val count = 1000
}

private fun updateItems(table: HashTable): Array<MutableList<String>> {
    val updatedItems = Array<MutableList<String>>(HashFunctions.module) { mutableListOf() }
    table.items.forEach {
        for (i in it) {
            updatedItems[table.hashFunction.getHash(i)].add(i)
        }
    }
    return updatedItems
}

class HashTable : IHashTable {

    var hashFunction = HashFunctions(HashKeys.Hash3)
    var items = Array<MutableList<String>>(HashFunctions.module) { mutableListOf() }
    var itemsQuantity = 0

    override fun plus(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("Element is empty.")

        for (it in items[hashFunction.getHash(value)]) {
            if (it == value) {
                throw CloneNotSupportedException("Element is already exist.")
            }
        }

        items[hashFunction.getHash(value)].add(value)
        itemsQuantity++
    }

    override fun minus(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("Element is empty.")

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
        if (value.isNullOrBlank()) throw KotlinNullPointerException("Element is empty.")

        items[hashFunction.getHash(value)].forEach {
            if (it == value) return hashFunction.getHash(value)
        }

        throw NoSuchElementException("Element is not exist.")
    }

    override fun getStatistics(): Statistics {
        return Statistics(
            getSize(this),
            getConflicts(this),
            getMaxLength(this),
            getLoadFactor(this))
    }

    override fun plusFromFile(fileName: String?) {
        if (fileName.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")

        val file = File(fileName)
        if (!file.exists()) throw NoSuchFileException(file, null, "File is not exist")

        file.forEachLine {
            plus(it)
            itemsQuantity++
        }
    }

    override fun chooseHashFunction(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("String is empty.")

        var isCorrect = false
        for (it in HashKeys.values()) {
            if (it.name == value) {
                hashFunction = HashFunctions(HashKeys.valueOf(value))
                items = updateItems(this)
                isCorrect = true
                break
            }
        }
        if (!isCorrect) throw IllegalArgumentException("String is not correct.")
    }
}
