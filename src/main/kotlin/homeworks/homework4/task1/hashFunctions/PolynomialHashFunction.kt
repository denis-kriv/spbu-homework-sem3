package homeworks.homework4.task1.hashFunctions

import homeworks.homework4.task1.hashFunctions.interfaces.IHashFunction

class PolynomialHashFunction(private val key: Int) :
    IHashFunction {
    override fun getHash(value: String, tableSize: Int): Int {
        var result = 0
        var deg = 1

        value.forEach {
            result += (it.hashCode() * deg) % tableSize
            deg *= key
        }

        return result % tableSize
    }
}
