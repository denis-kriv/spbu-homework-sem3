package tests.test2.task1

class ComparatorForInt : Comparator<Int> {
    override fun compare(value1: Int, value2: Int): Int {
        return when {
            value1 > value2 -> 1
            value1 < value2 -> -1
            else -> 0
        }
    }
}

class ComparatorForString : Comparator<String> {
    override fun compare(value1: String, value2: String): Int {
        return when {
            value1.length > value2.length -> 1
            value1.length < value2.length -> -1
            else -> 0
        }
    }
}
