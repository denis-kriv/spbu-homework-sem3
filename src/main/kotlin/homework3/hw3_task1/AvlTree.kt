package homework3.hw3_task1

class AvlTree<K : Comparable<K>, T>(var head: AvlTreeItem<K, T>?) : Map<K, T> {

    override val entries: Set<Map.Entry<K, T>>
        get() = TODO("Not yet implemented")
    override val keys: Set<K>
        get() = TODO("Not yet implemented")
    override val size: Int
        get() = TODO("Not yet implemented")
    override val values: Collection<T>
        get() = TODO("Not yet implemented")

    override fun containsKey(key: K): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: K): T? {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    private fun insert(treeHead: AvlTreeItem<K, T>?, insertingItem: Pair<K, T>): AvlTreeItem<K, T> {
        if (treeHead == null) return AvlTreeItem(insertingItem.first, insertingItem.second)
        if (insertingItem.first < treeHead.key) {
            treeHead.leftChild = insert(treeHead.leftChild!!, insertingItem)
        } else {
            treeHead.rightChild = insert(treeHead.rightChild!!, insertingItem)
        }
        return treeHead.balance()
    }

    fun plus(insertingItem: Pair<K, T>) {
        this.head = this.insert(this.head, insertingItem)
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
        if (item == null) return null
        when {
            key < item.key -> {
                item.leftChild = remove(item.leftChild, key)
            }
            key > item.key -> {
                item.rightChild = remove(item.rightChild, key)
            }
            else -> {
                if (item.rightChild == null) return item.leftChild
                var minKey = findMinKey(item.rightChild!!)
                minKey.rightChild = removeMinKey(item.rightChild!!)
                minKey.leftChild = item.leftChild
                return minKey.balance()
            }
        }
        return item.balance()
    }

    fun minus(key: K): AvlTreeItem<K, T>? {
        return remove(head, key)
    }
}
