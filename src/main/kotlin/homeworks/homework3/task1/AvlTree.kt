package homeworks.homework3.task1

class AvlTree<K : Comparable<K>, T>(key: K, value: T) : Map<K, T> {

    override var entries: Set<Map.Entry<K, T>> = mapOf(key to value).entries
    override var keys: Set<K> = setOf(key)
    override var size: Int = 1
    override var values: Collection<T> = listOf(value)
    private var head: AvlTreeItem<K, T>? = AvlTreeItem(key, value)

    override fun containsKey(key: K): Boolean {
        return this.keys.contains(key)
    }

    override fun containsValue(value: T): Boolean {
        return this.values.contains(value)
    }

    override fun get(key: K): T? {
        return head?.getValueByKey(key)
    }

    override fun isEmpty(): Boolean {
        return this.head == null
    }

    fun plus(insertingItem: Pair<K, T>) {
        if (this.keys.contains(insertingItem.first)) {
            throw CloneNotSupportedException("Element with this key is already exist.")
        }

        this.head = this.head?.insert(insertingItem) ?: AvlTreeItem(insertingItem.first, insertingItem.second)

        this.keys = this.keys.plus(insertingItem.first)
        this.values = this.values.plus(insertingItem.second)
        this.entries = this.entries.plus(mapOf(insertingItem.first to insertingItem.second).entries)
        this.size++
    }

    fun minus(key: K) {
        if (this.head == null) throw NullPointerException("Head is null.") else this.head = this.head?.remove(key)

        this.entries.forEach {
            if (it.key == key) {
                this.values = this.values.minus(it.value)
                this.keys = this.keys.minus(it.key)
                this.entries = this.entries.minus(mapOf(it.key to it.value).entries)
                this.size--
            }
        }
    }
}
