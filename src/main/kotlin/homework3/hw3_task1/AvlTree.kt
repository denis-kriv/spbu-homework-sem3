package homework3.hw3_task1

import kotlin.math.max

fun <K, T> smallLeftTurn(item: AvlTree<K, T>) {
    if (!(item.parent.isNullOrEmpty())) {
        item.rightChild!!.parent = item.parent
        if (equals(item.key) > equals(item.parent!!.key)) {
            item.parent!!.rightChild = item.rightChild
        } else {
            item.parent!!.leftChild = item.rightChild
        }
    }
    item.parent = item.rightChild!!
    if (!(item.parent!!.leftChild.isNullOrEmpty())) {
        item.rightChild = item.parent!!.leftChild
        item.rightChild!!.parent = item
    } else {
        item.rightChild = null
    }
    item.parent!!.leftChild = item
}

fun <K, T> smallRightTurn(item: AvlTree<K, T>) {
    if (!(item.parent.isNullOrEmpty())) {
        item.leftChild!!.parent = item.parent
        if (equals(item.key) > equals(item.parent!!.key)) {
            item.parent!!.rightChild = item.leftChild
        } else {
            item.parent!!.leftChild = item.leftChild
        }
    }
    item.parent = item.leftChild!!
    if (!(item.parent!!.rightChild.isNullOrEmpty())) {
        item.leftChild = item.parent!!.rightChild
        item.leftChild!!.parent = item
    } else {
        item.leftChild = null
    }
    item.parent!!.rightChild = item
}

fun <K, T> bigLeftTurn(item: AvlTree<K, T>) {
    smallRightTurn(item.rightChild!!)
    smallLeftTurn(item)
}

fun <K, T> bigRightTurn(item: AvlTree<K, T>) {
    smallLeftTurn(item.leftChild!!)
    smallRightTurn(item)
}

class AvlTree<K, T>(val key: K, val value: T) : Map<K, T> {
    override val entries: Set<Map.Entry<K, T>> = setOf()
    override val keys: Set<K> = setOf()
    override var size: Int = 0
    override val values: Collection<T> = listOf()
    var parent: AvlTree<K, T>? = null
    var leftChild: AvlTree<K, T>? = null
    var rightChild: AvlTree<K, T>? = null

    init {
        val pairForAdd: Pair<K, T> = key to value
        entries.plus(pairForAdd)
        keys.plus(key)
        values.plus(value)
        size = 1
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
        entries.forEach { if (equals(it.key) == equals(key)) return it.value }
        return null
    }

    override fun isEmpty(): Boolean {
        if (this.leftChild.isNullOrEmpty() && this.rightChild.isNullOrEmpty()) return false
        return true
    }

    fun addItem(addsItem: AvlTree<K, T>) {
        var itemForAdd = this

        while (!(itemForAdd.parent.isNullOrEmpty())) {
            itemForAdd = itemForAdd.parent!!
        }

        while (true) {
            val pairForAdd: Pair<K, T> = addsItem.key to addsItem.value
            itemForAdd.entries.plus(pairForAdd)
            itemForAdd.keys.plus(addsItem.key)
            itemForAdd.values.plus(addsItem.value)
            if (equals(itemForAdd.key) < equals(addsItem.key)) {
                if (itemForAdd.leftChild.isNullOrEmpty()) {
                    itemForAdd.leftChild = addsItem
                    break
                }
                itemForAdd = itemForAdd.leftChild!!
                continue
            }
            if (equals(itemForAdd.key) > equals(addsItem.key)) {
                if (itemForAdd.rightChild.isNullOrEmpty()) {
                    itemForAdd.rightChild = addsItem
                    break
                }
                itemForAdd = itemForAdd.rightChild!!
                continue
            }
        }

        while (!(itemForAdd.parent.isNullOrEmpty())) {
            itemForAdd.balance()
        }
    }

    private fun balance() {
        if (this.rightChild.isNullOrEmpty() && this.leftChild.isNullOrEmpty()) {
            this.size = 1
        } else if (this.rightChild.isNullOrEmpty() || this.leftChild.isNullOrEmpty()) {
            this.size = 2
            if (this.rightChild.isNullOrEmpty() && this.leftChild!!.size > 1) {
                if (this.leftChild!!.leftChild.isNullOrEmpty()) {

                } else if (this.leftChild!!.rightChild.isNullOrEmpty()) {

                } else if (this.leftChild!!.leftChild!!.size - this.leftChild!!.rightChild!!.size > 1) {

                } else if (this.leftChild!!.leftChild!!.size - this.leftChild!!.rightChild!!.size < -1) {

                }
            }
            if (this.leftChild.isNullOrEmpty() && this.rightChild!!.size > 1) {

            }
        } else {
            this.size = max(this.leftChild!!.size, this.rightChild!!.size) + 1
            if (this.leftChild!!.size > this.rightChild!!.size + 1) {

            }
            if (this.leftChild!!.size > this.rightChild!!.size + 1) {

            }
        }
    }

}