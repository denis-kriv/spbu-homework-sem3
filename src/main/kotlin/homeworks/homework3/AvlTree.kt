package homeworks.homework3

import java.lang.Exception

class AvlTree<K : Comparable<K>, T>(var head: AvlTreeItem<K, T>?) : Map<K, T> {

    override val entries: Set<Map.Entry<K, T>> = ((if (head == null) setOf() else setOf(head!!.key, head!!.value)) as Set<Map.Entry<K, T>>)
    override val keys: Set<K> = if (head == null) setOf() else setOf(head!!.key)
    override val size: Int = if (head == null) 0 else 1
    override val values: Collection<T> = if (head == null) listOf() else listOf(head!!.value)

    private fun getValueByKey(key: K, item: AvlTreeItem<K, T>?): T? {
        if (item == null) return null
        return when {
            item.key > key -> getValueByKey(key, item.rightChild)
            item.key < key -> getValueByKey(key, item.leftChild)
            else -> item.value
        }
    }

    private fun insert(treeHead: AvlTreeItem<K, T>?, insertingItem: Pair<K, T>): AvlTreeItem<K, T> {
        if (treeHead == null) return AvlTreeItem(
            insertingItem.first,
            insertingItem.second
        )
        if (insertingItem.first < treeHead.key) {
            treeHead.leftChild = insert(treeHead.leftChild!!, insertingItem)
        } else {
            treeHead.rightChild = insert(treeHead.rightChild!!, insertingItem)
        }
        return treeHead.balance()
    }

    private fun findMinKey(item: AvlTreeItem<K, T>): AvlTreeItem<K, T> {
        return if (item.leftChild == null) item else findMinKey(item.leftChild!!)
    }

    private fun removeMinKey(item: AvlTreeItem<K, T>): AvlTreeItem<K, T>? {
        if (item.leftChild == null) return item.rightChild
        item.leftChild = removeMinKey(item.leftChild!!)
        return item.balance()
    }

    private fun remove(item: AvlTreeItem<K, T>?, key: K): AvlTreeItem<K, T>? {
        if (item == null) throw Exception()
        when {
            key < item.key -> {
                item.leftChild = remove(item.leftChild, key)
            }
            key > item.key -> {
                item.rightChild = remove(item.rightChild, key)
            }
            else -> {
                if (item.rightChild == null) return item.leftChild
                val minKey = findMinKey(item.rightChild!!)
                minKey.rightChild = removeMinKey(item.rightChild!!)
                minKey.leftChild = item.leftChild
                return minKey.balance()
            }
        }
        return item.balance()
    }

    override fun containsKey(key: K): Boolean {
        if (this.head == null) throw Exception("")
        return keys.contains(key)
    }

    override fun containsValue(value: T): Boolean {
        if (this.head == null) throw Exception("")
        return values.contains(value)
    }

    override fun get(key: K): T? {
        if (this.head == null) throw Exception("")
        return getValueByKey(key, head)
    }

    override fun isEmpty(): Boolean {
        return this.head == null
    }

    fun plus(insertingItem: Pair<K, T>) {
        if (keys.contains(insertingItem.first)) throw Exception("")
        head = insert(head, insertingItem)
    }

    fun minus(key: K) {
        if (head == null) throw Exception("")
        this.head = remove(this.head, key)
    }
}
