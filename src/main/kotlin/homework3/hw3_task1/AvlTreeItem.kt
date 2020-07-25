package homework3.hw3_task1

class AvlTreeItem<K : Comparable<K>, T>(val key: K, val value: T) {
    var height = 1
    var leftChild: AvlTreeItem<K, T>? = null
    var rightChild: AvlTreeItem<K, T>? = null


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

    fun balance(): AvlTreeItem<K, T> {
        this.fixHeight()
        if (this.balanceFactor() == 2) {
            if (this.rightChild!!.balanceFactor() < 0) {
                this.rightChild = this.rightChild!!.rotateRight()
            }
            return this.rotateLeft()
        }
        if (this.balanceFactor() == -2) {
            if (this.leftChild!!.balanceFactor() > 0) {
                this.rightChild = this.rightChild!!.rotateLeft()
            }
            return this.rotateRight()
        }
        return this
    }
}
