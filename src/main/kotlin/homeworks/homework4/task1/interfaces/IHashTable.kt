package homeworks.homework4.task1.interfaces

import homeworks.homework4.task1.IHashFunction
import homeworks.homework4.task1.models.Statistics

interface IHashTable {
    fun plus(value: String?)
    fun minus(value: String?)
    fun getIndex(value: String?): Int
    fun getStatistics(): Statistics
    fun plusFromFile(fileName: String?)
    fun chooseHashFunction(hashFunction: IHashFunction)
}
