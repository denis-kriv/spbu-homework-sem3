package homeworks.homework4.task1.hashFunctions

import homeworks.homework4.task1.hashFunctions.interfaces.IHashFunction

class AdjacentCharactersHashFunction :
    IHashFunction {
    override fun getHash(value: String, tableSize: Int): Int {
        var result = 0

        for (i in 0 until value.length / 2 + value.length % 2) {
            result += value[i].hashCode() + value[value.lastIndex - i].hashCode()
            result %= tableSize
        }

        return result % tableSize
    }
}
