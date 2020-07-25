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
            treeHead.leftChild = insert(treeHead.leftChild!!, insertingItem)
        }
        return treeHead.balance()
    }

    fun plus(insertingItem: Pair<K, T>) {
        this.head = this.insert(this.head, insertingItem)
    }

    private fun findMinKey(item: AvlTreeItem<K, T>) : AvlTreeItem<K, T> {
        return if (item.leftChild == null) item else findMinKey(item.leftChild!!)
    }


}
