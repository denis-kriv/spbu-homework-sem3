package homework3.hw3_task1

fun <K : Comparable<K>, T> smallLeftTurn(item: AvlTreeItem<K, T>) {
    if (item.parent != null) {
        item.rightChild!!.parent = item.parent
        if (item.key > item.parent!!.key) {
            item.parent!!.rightChild = item.rightChild
        } else {
            item.parent!!.leftChild = item.rightChild
        }
    }
    item.parent = item.rightChild!!
    if ((item.parent!!.leftChild != null)) {
        item.rightChild = item.parent!!.leftChild
        item.rightChild!!.parent = item
    } else {
        item.rightChild = null
    }
    item.parent!!.leftChild = item
    
}

fun <K : Comparable<K>, T> smallRightTurn(item: AvlTreeItem<K, T>) {
    if ((item.parent != null)) {
        item.leftChild!!.parent = item.parent
        if (item.key > item.parent!!.key) {
            item.parent!!.rightChild = item.leftChild
        } else {
            item.parent!!.leftChild = item.leftChild
        }
    }
    item.parent = item.leftChild!!
    if ((item.parent!!.rightChild != null)) {
        item.leftChild = item.parent!!.rightChild
        item.leftChild!!.parent = item
    } else {
        item.leftChild = null
    }
    item.parent!!.rightChild = item
}

fun <K : Comparable<K>, T> bigLeftTurn(item: AvlTreeItem<K, T>) {
    smallRightTurn(item.rightChild!!)
    smallLeftTurn(item)
}

fun <K : Comparable<K>, T> bigRightTurn(item: AvlTreeItem<K, T>) {
    smallLeftTurn(item.leftChild!!)
    smallRightTurn(item)
}

class AvlTreeItem<K : Comparable<K>, T>(val key: K, val value: T) : Map<K, T> {
    override val entries: Set<Map.Entry<K, T>> = setOf()
    override val keys: Set<K> = setOf()
    override var size: Int = 1
    override val values: Collection<T> = listOf()

    var parent: AvlTreeItem<K, T>? = null
    var leftChild: AvlTreeItem<K, T>? = null
    var rightChild: AvlTreeItem<K, T>? = null
    var balanceCoefficient: Int = 0

    init {
        val pairForAdd: Pair<K, T> = key to value
        entries.plus(pairForAdd)
        keys.plus(key)
        values.plus(value)
    }

    override fun containsKey(key: K): Boolean {
        keys.forEach { if (equals(it) == equals(key)) return true }
        return false
    }

    override fun containsValue(value: T): Boolean {
        entries.forEach { if (equals(it) == equals(value)) return true }
        return false
    }

    override fun get(key: K): T? {
        entries.forEach { if (it.key == key) return it.value }
        return null
    }

    override fun isEmpty(): Boolean {
        return (rightChild == null && leftChild == null)
    }

    fun balance() {
        if (balanceCoefficient == 2) {
            if (rightChild!!.balanceCoefficient >= 0) {
                smallLeftTurn(this)
            }
            if (rightChild!!.balanceCoefficient < 0) {
                bigLeftTurn(this)
            }
        }
        if (balanceCoefficient == -2) {
            if (leftChild!!.balanceCoefficient <= 0) {
                smallRightTurn(this)
            }
            if (leftChild!!.balanceCoefficient > 0) {
                bigRightTurn(this)
            }
        }
    }
}