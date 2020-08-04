package homeworks.homework4.task1

import homeworks.homework4.task1.enums.HashKeys

class HashFunctions(value: HashKeys) {

    var key = value.key

    var getHash = when (value) {
        HashKeys.Hash3 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += (it.hashCode() * deg) % Companion.module
                deg *= HashKeys.Hash3.key
            }
            return result % Companion.module
        }

        HashKeys.Hash5 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % Companion.module
                deg *= HashKeys.Hash5.key
            }
            return result % Companion.module
        }

        HashKeys.Hash7 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % Companion.module
                deg *= HashKeys.Hash7.key
            }
            return result % Companion.module
        }

        HashKeys.Hash11 -> fun(value: String): Int {
            var result = 0
            var deg = 1
            value.forEach {
                result += it.hashCode() * deg % Companion.module
                deg *= HashKeys.Hash11.key
            }
            return result % Companion.module
        }
    }

    companion object {
        const val module: Int = 2048
    }
}
