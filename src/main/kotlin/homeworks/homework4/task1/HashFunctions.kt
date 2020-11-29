package homeworks.homework4.task1

interface IHashFunction {
    fun getHash(value: String, tableSize: Int): Int
}

class PolynomialHashFunction(private val key: Int) : IHashFunction {
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

class AdjacentCharactersHashFunction : IHashFunction {
    override fun getHash(value: String, tableSize: Int): Int {
        var result = 0

        for (i in 0 until value.length / 2 + value.length % 2) {
            result += value[i].hashCode() + value[value.lastIndex - i].hashCode()
            result %= tableSize
        }

        return result % tableSize
    }
}

class QuadraticHashFunction : IHashFunction {
    override fun getHash(value: String, tableSize: Int): Int {
        var result = 0

        for (i in 0 until value.length / 2 + value.length % 2) {
            result += value[i].hashCode() + value[value.lastIndex - i].hashCode()
            result %= tableSize
        }

        return result % tableSize
    }
}

