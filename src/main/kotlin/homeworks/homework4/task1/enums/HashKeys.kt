package homeworks.homework4.task1.enums

enum class HashKeys(val key: Int) {
    Hash3(Keys.keyForHashKeys3),
    Hash5(Keys.keyForHashKeys5),
    Hash7(Keys.keyForHashKeys7),
    Hash11(Keys.keyForHashKeys11)
}

private object Keys {
    const val keyForHashKeys3: Int = 3
    const val keyForHashKeys5: Int = 5
    const val keyForHashKeys7: Int = 7
    const val keyForHashKeys11: Int = 11
}
