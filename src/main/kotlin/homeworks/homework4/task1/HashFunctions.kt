package homeworks.homework4.task1

import homeworks.homework4.task1.enums.HashModules

class HashFunctions(value: HashModules) {
    
    private val module = 2048

    var getHash = when (value) {
        HashModules.HASH3 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += (it.hashCode() * deg) % module
                deg *= 3
            }
            return result % module
        }

        HashModules.HASH5 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % module
                deg *= 5
            }
            return result % module
        }

        HashModules.HASH7 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % module
                deg *= 7
            }
            return result % module
        }

        HashModules.HASH11 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % module
                deg *= 11
            }
            return result % module
        }
    }
}
