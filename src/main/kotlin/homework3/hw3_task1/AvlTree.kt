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

class AvlTree<K, T>(val key: K, private val value: T) : Map<K, T> {
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
            itemForAdd.resize()
            itemForAdd.balance()
        }
    }

    fun delete(key: K) {
        var deletesItem = this
        var itemForBalance = this
        while (true) {
            if (deletesItem.parent.isNullOrEmpty()) break
            deletesItem = deletesItem.parent!!
        }
        while (true) {
            if (equals(deletesItem.key) == key) break
            if (equals(deletesItem.key) < equals(key)) {
                deletesItem = deletesItem.rightChild!!
            }
            if (equals(deletesItem.key) > equals(key)) {
                deletesItem = deletesItem.leftChild!!
            }
        }
        if (deletesItem.parent.isNullOrEmpty()) {
            if (deletesItem.leftChild.isNullOrEmpty() && deletesItem.rightChild.isNullOrEmpty()) {
                return
            } else if (deletesItem.leftChild.isNullOrEmpty() || deletesItem.rightChild.isNullOrEmpty()) {
                if (deletesItem.leftChild.isNullOrEmpty()) {
                    deletesItem.rightChild!!.parent = null
                    deletesItem.rightChild = null
                } else {
                    deletesItem.leftChild!!.parent = null
                    deletesItem.leftChild = null
                }
            } else {
                var itemForSwap = deletesItem.leftChild!!
                while (!(itemForSwap.rightChild.isNullOrEmpty())) {
                    itemForSwap = itemForSwap.rightChild!!
                }
                itemForBalance = itemForSwap.parent!!
                itemForSwap.rightChild = deletesItem.rightChild
                itemForSwap.leftChild = deletesItem.leftChild
                itemForSwap.leftChild = itemForSwap
                itemForSwap.rightChild = itemForSwap
            }
        }
        if (!(deletesItem.parent.isNullOrEmpty())) {
            if (deletesItem.leftChild.isNullOrEmpty() && deletesItem.rightChild.isNullOrEmpty()) {
                return
            } else if (deletesItem.leftChild.isNullOrEmpty() || deletesItem.rightChild.isNullOrEmpty()) {
                if (deletesItem.leftChild.isNullOrEmpty()) {
                    if (equals(deletesItem.parent!!.key) < equals(deletesItem.key)) {
                        deletesItem.parent!!.parent
                    } else {

                    }
                } else {
                    if (equals(deletesItem.parent!!.key) < equals(deletesItem.key)) {

                    } else {

                    }
                }
            } else {
                var itemForSwap = deletesItem.leftChild!!
                while (!(itemForSwap.rightChild.isNullOrEmpty())) {
                    itemForSwap = itemForSwap.rightChild!!
                }
                itemForBalance = itemForSwap.parent!!
                itemForSwap.rightChild = deletesItem.rightChild
                itemForSwap.leftChild = deletesItem.leftChild
                itemForSwap.leftChild = itemForSwap
                itemForSwap.rightChild = itemForSwap
            }
        }


    }

    private fun resize() {
        if (this.rightChild.isNullOrEmpty() && this.leftChild.isNullOrEmpty()) {
            this.size = 1
        } else if (this.rightChild.isNullOrEmpty() || this.leftChild.isNullOrEmpty()) {
            this.size = 2
        } else {
            this.size = max(this.leftChild!!.size, this.rightChild!!.size) + 1
        }
    }

    private fun balance() {
        if (this.rightChild.isNullOrEmpty() && this.leftChild.isNullOrEmpty()) return
        val rightSize = this.rightChild?.size ?: 0
        val leftSize = this.leftChild?.size ?: 0
        if (leftSize > rightSize + 1) {
            val leftChildRightSize = this.rightChild!!.rightChild?.size ?: 0
            val leftChildLeftSize = this.rightChild!!.leftChild?.size ?: 0
            if (leftChildRightSize <= leftChildLeftSize) {
                smallRightTurn(this)
                return
            }
            if (leftChildRightSize > leftChildLeftSize) {
                bigRightTurn(this)
                return
            }
        }
        if (rightSize > leftSize + 1) {
            val rightChildRightSize = this.rightChild!!.rightChild?.size ?: 0
            val rightChildLeftSize = this.rightChild!!.leftChild?.size ?: 0
            if (rightChildLeftSize <= rightChildRightSize) {
                smallLeftTurn(this)
                return
            }
            if (rightChildLeftSize > rightChildRightSize) {
                bigLeftTurn(this)
                return
            }
        }
    }
}