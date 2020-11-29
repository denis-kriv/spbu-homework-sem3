package homeworks.homework4.task1.hashFunctions.interfaces

interface IHashFunction {
    fun getHash(value: String, tableSize: Int): Int
}
