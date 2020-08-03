package homeworks.homework4.task1

class HashFunctions(index: Int) {
    var getHash = when (index) {
        0 -> fun(value: String): Int {return 0}
        1 -> fun(value: String): Int {return 0}
        else -> throw ArithmeticException("Function with this number is not exist.")
    }
}