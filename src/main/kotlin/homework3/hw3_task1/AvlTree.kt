package homework3.hw3_task1

fun <K : Comparable<K>, T> add(addsItem: AvlTreeItem<K, T>, itemForAdd: AvlTreeItem<K, T>, tree: AvlTree<K, T>) {
    if (itemForAdd.key < addsItem.key) {
        if (itemForAdd.rightChild == null) {
            itemForAdd.rightChild = addsItem
            addsItem.parent = itemForAdd
        } else {
            add(addsItem, itemForAdd.rightChild!!, tree)
        }
    } else if (itemForAdd.key > addsItem.key) {
        if (itemForAdd.leftChild == null) {
            itemForAdd.leftChild = addsItem
            addsItem.parent = itemForAdd
        } else {
            add(addsItem, itemForAdd.leftChild!!, tree)
        }
    }
    itemForAdd.entries.plus(Pair(addsItem.key, addsItem.value))
    itemForAdd.values.plus(addsItem.value)
    itemForAdd.keys.plus(addsItem.key)
    itemForAdd.size = maxOf(itemForAdd.rightChild?.size ?: 0, itemForAdd.leftChild?.size ?: 0) + 1
    itemForAdd.balanceCoefficient = (itemForAdd.rightChild?.size ?: 0) - (itemForAdd.leftChild?.size ?: 0)
    itemForAdd.balance(tree)
}

fun <K : Comparable<K>, T> delete(key: K, item: AvlTreeItem<K, T>, tree: AvlTree<K, T>) {
    if (item.key < key) {
        delete(key, item.rightChild!!, tree)
    } else if (item.key > key) {
        delete(key, item.leftChild!!, tree)
    } else {
        if (item.leftChild == null && item.rightChild == null) {
            deleteList(item)
        } else if (item.leftChild == null || item.rightChild == null) {
            deleteWithOneChild(item)
        } else {
            val itemForSwap = swap(item.leftChild!!, item)
            delete(key, itemForSwap, tree)
        }
    }
    //item.entries.minus(Pair<K, T>(key, tree.head[key]!!))
    item.values.plus(tree.head[key])
    item.keys.plus(tree.head[key])
    item.size = maxOf(item.rightChild?.size ?: 0, item.leftChild?.size ?: 0) + 1
    item.balanceCoefficient = (item.rightChild?.size ?: 0) - (item.leftChild?.size ?: 0)
    item.balance(tree)
}

fun <K : Comparable<K>, T> deleteList(item: AvlTreeItem<K, T>) {
    if (item.parent!!.key > item.key) item.parent!!.leftChild = null else item.parent!!.rightChild = null
}

fun <K : Comparable<K>, T> deleteWithOneChild(item: AvlTreeItem<K, T>) {
    if (item.parent!!.key > item.key) {
        if (item.leftChild == null) {
            item.parent!!.leftChild = item.rightChild
            item.rightChild!!.parent = item.parent
        } else {
            item.parent!!.leftChild = item.leftChild
            item.leftChild!!.parent = item.parent
        }
    } else {
        if (item.leftChild == null) {
            item.parent!!.rightChild = item.rightChild
            item.rightChild!!.parent = item.parent
        } else {
            item.parent!!.rightChild = item.leftChild
            item.leftChild!!.parent = item.parent
        }
    }
}

fun <K : Comparable<K>, T> swap(itemForSwap: AvlTreeItem<K, T>, item: AvlTreeItem<K, T>): AvlTreeItem<K, T> {
    if (itemForSwap.rightChild != null) {
        return swap(itemForSwap.rightChild!!, item)
    } else {
        val helpItem = itemForSwap.parent
        if (item.parent!!.key > item.key) {
            item.parent!!.leftChild = itemForSwap
        } else {
            item.parent!!.rightChild = itemForSwap
        }
        itemForSwap.parent = item.parent
        helpItem!!.rightChild = item
        item.parent = helpItem
        itemForSwap.leftChild = item.leftChild
        item.leftChild!!.parent = itemForSwap
        itemForSwap.rightChild = item.rightChild
        item.rightChild!!.parent = itemForSwap
        item.leftChild = null
        item.rightChild = null
        itemForSwap.entries.plus(item.entries)
        itemForSwap.keys.plus(item.keys)
        itemForSwap.values.plus(item.values)
        itemForSwap.size = item.size
        itemForSwap.balanceCoefficient = item.balanceCoefficient
    }
    return itemForSwap
}

class AvlTree<K : Comparable<K>, T>(var head: AvlTreeItem<K, T>) {
    fun plus(addsItem: AvlTreeItem<K, T>) {
        if (head.containsKey(addsItem.key)) throw Exception("Key exists")
        add(addsItem, head, this)
    }

    fun minus(key: K) {
        delete(key, head, this)
    }
}
