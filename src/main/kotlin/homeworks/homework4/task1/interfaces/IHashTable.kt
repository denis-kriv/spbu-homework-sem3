package homeworks.homework4.task1.interfaces

interface IHashTable {
    fun plus(value: String?)
    fun minus(value: String?)
    fun getIndex(value: String?): Int
    fun getStatistics(): List<String>
    fun plusFromFile(fileName: String?)
    fun chooseHashFunction(value: String?)
}
