package homeworks.homework4.task1

import homeworks.homework4.task1.enums.HashModules

class HashFunctions(module: HashModules) {
    var getHash = when (module) {
        HashModules.HASH3 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += (it.hashCode() * deg) % 2048
                deg *= 3
            }
            return result % 2048
        }

        HashModules.HASH5 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % 2048
                deg *= 5
            }
            return result % 2048
        }

        HashModules.HASH7 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % 2048
                deg *= 7
            }
            return result % 2048
        }

        HashModules.HASH11 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % 2048
                deg *= 11
            }
            return result % 2048
        }
    }
}
