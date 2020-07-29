package homeworks.homework3

import java.lang.Exception

private fun <K : Comparable<K>, T> getValueByKey(key: K, item: AvlTreeItem<K, T>?): T? {
    if (item == null) return null

    return when {
        key > item.key -> getValueByKey(key, item.rightChild)
        key < item.key -> getValueByKey(key, item.leftChild)
        else -> item.value
    }
}

private fun <K : Comparable<K>, T> insert(treeHead: AvlTreeItem<K, T>?, insertingItem: Pair<K, T>): AvlTreeItem<K, T> {
    if (treeHead == null) return AvlTreeItem(insertingItem.first, insertingItem.second)

    if (insertingItem.first < treeHead.key) {
        treeHead.leftChild = insert(treeHead.leftChild, insertingItem)
    } else {
        treeHead.rightChild = insert(treeHead.rightChild, insertingItem)
    }

    return treeHead.balance()
}

private fun <K : Comparable<K>, T> findMinKey(item: AvlTreeItem<K, T>): AvlTreeItem<K, T> {
    return if (item.leftChild == null) item else findMinKey(item.leftChild!!)
}

private fun <K : Comparable<K>, T> removeMinKey(item: AvlTreeItem<K, T>): AvlTreeItem<K, T>? {
    if (item.leftChild == null) return item.rightChild

    item.leftChild = removeMinKey(item.leftChild!!)

    return item.balance()
}

private fun <K : Comparable<K>, T> remove(item: AvlTreeItem<K, T>?, key: K): AvlTreeItem<K, T>? {
    if (item == null) throw NoSuchElementException("Element with this key does not exist.")

    return when {
        key < item.key -> {
            item.leftChild = remove(item.leftChild, key)
            item.balance()
        }
        key > item.key -> {
            item.rightChild = remove(item.rightChild, key)
            item.balance()
        }
        else -> {
            if (item.rightChild == null) return item.leftChild
            val minKey = findMinKey(item.rightChild!!)
            minKey.rightChild = removeMinKey(item.rightChild!!)
            minKey.leftChild = item.leftChild
            minKey.balance()
        }
    }
}

class AvlTree<K : Comparable<K>, T>(key: K, value: T) : Map<K, T> {

    override var entries: Set<Map.Entry<K, T>> = mapOf(key to value).entries
    override var keys: Set<K> = setOf(key)
    override var size: Int = 1
    override var values: Collection<T> = listOf(value)
    private var head: AvlTreeItem<K, T>? = AvlTreeItem(key, value)

    override fun containsKey(key: K): Boolean {
        return this.keys.contains(key)
    }

    override fun containsValue(value: T): Boolean {
        return this.values.contains(value)
    }

    override fun get(key: K): T? {
        return getValueByKey(key, this.head)
    }

    override fun isEmpty(): Boolean {
        return this.head == null
    }

    fun plus(insertingItem: Pair<K, T>) {
        if (this.keys.contains(insertingItem.first))
            throw CloneNotSupportedException("Element with this key is already exist.")

        this.head = insert(this.head, insertingItem)

        this.keys = this.keys.plus(insertingItem.first)
        this.values = this.values.plus(insertingItem.second)
        this.entries = this.entries.plus(mapOf(insertingItem.first to insertingItem.second).entries)
        this.size++
    }

    fun minus(key: K) {
        if (this.head == null) throw NullPointerException("Head is null.")

        this.head = remove(this.head, key)

        this.entries.forEach {
            if (it.key == key) {
                this.values = this.values.minus(it.value)
                this.keys = this.keys.minus(it.key)
                this.entries = this.entries.minus(mapOf(it.key to it.value).entries)
                this.size--
            }
        }
    }
}
