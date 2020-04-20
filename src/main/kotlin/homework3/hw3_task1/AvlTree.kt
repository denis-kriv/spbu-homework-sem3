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
            deleteWithTwoChildren(item.leftChild!!, item, tree)
            item.leftChild!!.parent!!.balance(tree)
        }
    }
    /*item.entries.minus(Pair<K, T>())
    item.values.plus(addsItem.value)
    item.keys.plus(addsItem.key)
    item.size = maxOf(item.rightChild?.size ?: 0, item.leftChild?.size ?: 0) + 1
    item.balanceCoefficient = (item.rightChild?.size ?: 0) - (item.leftChild?.size ?: 0)*/
    item.parent!!.balance(tree)
}

fun <K : Comparable<K>, T> deleteList(item: AvlTreeItem<K, T>) {
    if (item.parent!!.key > item.key) item.parent!!.leftChild = null else item.parent!!.rightChild = null
}

fun <K : Comparable<K>, T> deleteWithOneChild(item: AvlTreeItem<K, T>) {
    if (item.parent!!.key > item.key) {
        item.parent!!.leftChild = if (item.leftChild == null) item.rightChild else item.leftChild
    } else {
        item.parent!!.rightChild = if (item.leftChild == null) item.rightChild else item.leftChild
    }
}

fun <K : Comparable<K>, T> deleteWithTwoChildren(
    itemForSwap: AvlTreeItem<K, T>,
    item: AvlTreeItem<K, T>,
    tree: AvlTree<K, T>
) {
    if (itemForSwap.rightChild != null) {
        deleteWithTwoChildren(itemForSwap.rightChild!!, item, tree)
        itemForSwap.size = maxOf(itemForSwap.rightChild?.size ?: 0, itemForSwap.leftChild?.size ?: 0) + 1
        itemForSwap.balanceCoefficient = (itemForSwap.rightChild?.size ?: 0) - (itemForSwap.leftChild?.size ?: 0)
        itemForSwap.balance(tree)
    } else {
        itemForSwap.parent!!.rightChild = null
        itemForSwap.parent = item.parent
        if (item.parent!!.key > item.key) {
            item.parent!!.leftChild = itemForSwap
        } else {
            item.parent!!.rightChild = itemForSwap
        }
        itemForSwap.leftChild = item.leftChild
        item.leftChild!!.parent = itemForSwap
        itemForSwap.rightChild = item.rightChild
        item.rightChild!!.parent = itemForSwap
        //entries...
    }
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