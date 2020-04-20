package homework3.hw3_task1

fun <K : Comparable<K>, T> smallLeftTurn(item: AvlTreeItem<K, T>, tree: AvlTree<K, T>) {
    if (item.parent != null) {
        item.rightChild!!.parent = item.parent
        if (item.key > item.parent!!.key) {
            item.parent!!.rightChild = item.rightChild
        } else {
            item.parent!!.leftChild = item.rightChild
        }
    } else {
        tree.head = item.rightChild!!
    }
    item.parent = item.rightChild!!
    if ((item.parent!!.leftChild != null)) {
        item.rightChild = item.parent!!.leftChild
        item.rightChild!!.parent = item
    } else {
        item.rightChild = null
    }
    item.parent!!.leftChild = item
    item.size = maxOf(item.rightChild?.size ?: 0, item.leftChild?.size ?: 0) + 1
    item.balanceCoefficient = (item.rightChild?.size ?: 0) - (item.leftChild?.size ?: 0)
    item.parent!!.size = maxOf(item.parent!!.rightChild?.size ?: 0, item.parent!!.leftChild?.size ?: 0) + 1
    item.parent!!.balanceCoefficient = (item.parent!!.rightChild?.size ?: 0) - (item.parent!!.leftChild?.size ?: 0)
    if (item.parent!!.parent != null) {
        item.parent!!.parent!!.size =
            maxOf(item.parent!!.parent!!.rightChild?.size ?: 0, item.parent!!.parent!!.leftChild?.size ?: 0) + 1
        item.parent!!.parent!!.balanceCoefficient =
            (item.parent!!.parent!!.rightChild?.size ?: 0) - (item.parent!!.parent!!.leftChild?.size ?: 0)
    }
}

fun <K : Comparable<K>, T> smallRightTurn(item: AvlTreeItem<K, T>, tree: AvlTree<K, T>) {
    if (item.parent != null) {
        item.leftChild!!.parent = item.parent
        if (item.key > item.parent!!.key) {
            item.parent!!.rightChild = item.leftChild
        } else {
            item.parent!!.leftChild = item.leftChild
        }
    } else {
        tree.head = item.leftChild!!
    }
    item.parent = item.leftChild!!
    if ((item.parent!!.rightChild != null)) {
        item.leftChild = item.parent!!.rightChild
        item.leftChild!!.parent = item
    } else {
        item.leftChild = null
    }
    item.parent!!.rightChild = item
    item.size = maxOf(item.rightChild?.size ?: 0, item.leftChild?.size ?: 0) + 1
    item.balanceCoefficient = (item.rightChild?.size ?: 0) - (item.leftChild?.size ?: 0)
    item.parent!!.size = maxOf(item.parent!!.rightChild?.size ?: 0, item.parent!!.leftChild?.size ?: 0) + 1
    item.parent!!.balanceCoefficient = (item.parent!!.rightChild?.size ?: 0) - (item.parent!!.leftChild?.size ?: 0)
    if (item.parent!!.parent != null) {
        item.parent!!.parent!!.size =
            maxOf(item.parent!!.parent!!.rightChild?.size ?: 0, item.parent!!.parent!!.leftChild?.size ?: 0) + 1
        item.parent!!.parent!!.balanceCoefficient =
            (item.parent!!.parent!!.rightChild?.size ?: 0) - (item.parent!!.parent!!.leftChild?.size ?: 0)
    }
}

fun <K : Comparable<K>, T> bigLeftTurn(item: AvlTreeItem<K, T>, tree: AvlTree<K, T>) {
    smallRightTurn(item.rightChild!!, tree)
    smallLeftTurn(item, tree)
}

fun <K : Comparable<K>, T> bigRightTurn(item: AvlTreeItem<K, T>, tree: AvlTree<K, T>) {
    smallLeftTurn(item.leftChild!!, tree)
    smallRightTurn(item, tree)
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

    fun balance(tree: AvlTree<K, T>) {
        if (balanceCoefficient == 2) {
            if (rightChild!!.balanceCoefficient >= 0) {
                smallLeftTurn(this, tree)
            } else if (rightChild!!.balanceCoefficient < 0) {
                bigLeftTurn(this, tree)
            }
        } else if (balanceCoefficient == -2) {
            if (leftChild!!.balanceCoefficient <= 0) {
                smallRightTurn(this, tree)
            } else if (leftChild!!.balanceCoefficient > 0) {
                bigRightTurn(this, tree)
            }
        }
    }
}