package homeworks.homework4.task1.interfaces

import homeworks.homework4.task1.hashFunctions.interfaces.IHashFunction
import homeworks.homework4.task1.models.Statistics

interface IHashTable {
    fun getItems(): List<String>
    fun plus(value: String?)
    fun minus(value: String?)
    fun getIndex(value: String?): Int
    fun getStatistics(): Statistics
    fun plusFromFile(fileName: String?)
    fun chooseHashFunction(hashFunction: IHashFunction)
}
