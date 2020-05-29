package tests.test2.task1

class comparatorForInt : Comparator<Int> {
    override fun compare(value1: Int, value2: Int): Int {
        if (value1 > value2) return 1
        if (value1 < value2) return -1
        return 0
    }
}

class comparatorForString : Comparator<String> {
    override fun compare(value1: String, value2: String): Int {
        if (value1.length > value2.length) return 1
        if (value1.length < value2.length) return -1
        return 0
    }
}