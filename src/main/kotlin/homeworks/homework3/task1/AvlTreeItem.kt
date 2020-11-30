package homeworks.homework3.task1

class AvlTreeItem<K : Comparable<K>, T>(private val key: K, private val value: T) {

    var height = 1
    var leftChild: AvlTreeItem<K, T>? = null
    var rightChild: AvlTreeItem<K, T>? = null

    private fun findMinKey(): AvlTreeItem<K, T> {
        return this.leftChild?.findMinKey() ?: this
    }

    private fun removeMinKey(): AvlTreeItem<K, T>? {
        this.leftChild = this.leftChild?.removeMinKey() ?: this.rightChild

        return this.balance()
    }

    private fun balanceFactor(): Int {
        return (this.rightChild?.height ?: 0) - (this.leftChild?.height ?: 0)
    }

    private fun fixHeight() {
        val leftHeight = this.leftChild?.height ?: 0
        val rightHeight = this.rightChild?.height ?: 0
        this.height = maxOf(leftHeight, rightHeight) + 1
    }

    private fun rotateRight(): AvlTreeItem<K, T> {
        val item: AvlTreeItem<K, T> = this.leftChild!!
        this.leftChild = item.rightChild
        item.rightChild = this

        this.fixHeight()
        item.fixHeight()

        return item
    }

    private fun rotateLeft(): AvlTreeItem<K, T> {
        val item: AvlTreeItem<K, T> = this.rightChild!!
        this.rightChild = item.leftChild
        item.leftChild = this

        this.fixHeight()
        item.fixHeight()

        return item
    }

    fun getValueByKey(key: K): T? {
        return when {
            key > this.key -> this.rightChild?.getValueByKey(key)
            key < this.key -> this.leftChild?.getValueByKey(key)
            else -> this.value
        }
    }

    fun insert(insertingItem: Pair<K, T>): AvlTreeItem<K, T> {
        if (insertingItem.first < this.key) {
            this.leftChild = this.leftChild?.insert(insertingItem)
                ?: AvlTreeItem(insertingItem.first, insertingItem.second)
        } else {
            this.rightChild = this.rightChild?.insert(insertingItem)
                ?: AvlTreeItem(insertingItem.first, insertingItem.second)
        }

        return this.balance()
    }

    fun remove(key: K): AvlTreeItem<K, T>? {
        return when {
            key < this.key -> {
                if (this.leftChild == null) throw NoSuchElementException("Element with this key does not exist.")
                this.leftChild = this.leftChild?.remove(key)

                this.balance()
            }
            key > this.key -> {
                if (this.rightChild == null) throw NoSuchElementException("Element with this key does not exist.")
                this.rightChild = this.rightChild?.remove(key)

                this.balance()
            }
            else -> {
                if (this.rightChild == null) return this.leftChild

                val minKey = this.rightChild!!.findMinKey()

                minKey.rightChild = this.rightChild!!.removeMinKey()
                minKey.leftChild = this.leftChild
                minKey.balance()
            }
        }
    }

    fun balance(): AvlTreeItem<K, T> {
        this.fixHeight()

        return when {
            this.balanceFactor() == 2 -> {
                if (this.balanceFactor() < 0) this.rightChild = this.rightChild!!.rotateRight()
                this.rotateLeft()
            }
            -this.balanceFactor() == 2 -> {
                if (this.leftChild!!.balanceFactor() > 0) this.rightChild = this.rightChild!!.rotateLeft()
                this.rotateRight()
            }
            else -> {
                this
            }
        }
    }
}
