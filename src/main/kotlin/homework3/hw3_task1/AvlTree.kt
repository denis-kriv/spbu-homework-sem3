package homework3.hw3_task1

class AvlTree<K : Comparable<K>, T>(var head: AvlTreeItem<K, T>?) {
    
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
}
