package homeworks.homework4.task1

import homeworks.homework4.task1.interfaces.IHashTable
import java.io.File
import java.util.NoSuchElementException
import homeworks.homework4.task1.models.Statistics

class HashTable(arraySize: Int) : IHashTable {
    private var hashFunction: IHashFunction = QuadraticHashFunction()
    private var itemsQuantity = 0
    private var items = if (arraySize > 0) {
        Array<MutableList<String>>(arraySize) { mutableListOf() }
    } else {
        throw ArithmeticException("Table size must be a natural number.")
    }

    override fun plus(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("Element is empty.")

        for (it in items[hashFunction.getHash(value, items.size)]) {
            if (it == value) throw CloneNotSupportedException("Element is already exist.")
        }

        items[hashFunction.getHash(value, items.size)].add(value)
        itemsQuantity++
    }

    override fun minus(value: String?) {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("Element is empty.")

        var isExist = false

        for (it in items[hashFunction.getHash(value, items.size)]) {
            if (it == value) {
                isExist = true
                break
            }
        }

        if (isExist) {
            items[hashFunction.getHash(value, items.size)].remove(value)
            itemsQuantity--
        } else {
            throw NoSuchElementException("Element is not exist.")
        }
    }

    override fun getIndex(value: String?): Int {
        if (value.isNullOrBlank()) throw KotlinNullPointerException("Element is empty.")

        items[hashFunction.getHash(value, items.size)].forEach {
            if (it == value) return hashFunction.getHash(value, items.size)
        }

        throw NoSuchElementException("Element is not exist.")
    }

    override fun getStatistics(): Statistics {
        var conflicts = 0
        this.items.forEach { if (it.size > 1) conflicts++ }

        var maxLength = 0
        this.items.forEach { if (it.size > maxLength) maxLength = it.size }

        val result = this.itemsQuantity.toDouble() / this.items.size.toDouble()

        return Statistics(this.items.size, conflicts, maxLength, result)
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

    override fun chooseHashFunction(hashFunction: IHashFunction) {
        this.hashFunction = hashFunction

        val result = Array<MutableList<String>>(items.size) { mutableListOf() }

        items.forEach {
            it.forEach { i ->
                result[hashFunction.getHash(i, items.size)].add(i)
            }
        }

        items = result
    }
}
