package homeworks.homework5.task1.models

class TrieItem(private val value: String) {

    private val children: MutableList<TrieItem> = mutableListOf()
    private var isTerminal: Boolean = false
    private var size = 0

    fun plus(element: String): Boolean {
        if (element == this.value) {
            if (!this.isTerminal) this.size++

            val isExist = this.isTerminal
            this.isTerminal = true

            return !isExist
        }

        var currentItem: TrieItem? = null
        val index = if (this.value == "") 0 else 1

        for (i in this.children) {
            if (i.value == element[index].toString()) {
                currentItem = i
                break
            }
        }

        if (currentItem == null) {
            currentItem = TrieItem(element[index].toString())
            this.children.add(currentItem)
        }

        val result = currentItem.plus(element.substring(index))
        if (result) this.size++

        return result
    }

    fun isExist(element: String): Boolean {
        if (this.value == element) return this.isTerminal

        var result = false
        val index = if (this.value == "") 0 else 1

        for (i in this.children) {
            if (i.value == element[index].toString()) result = i.isExist(element.substring(index))
        }

        return result
    }

    fun minus(element: String): Boolean {
        if (this.value == element) {
            if (this.isTerminal) this.size--

            val isExist = this.isTerminal
            this.isTerminal = false

            return isExist
        }

        var currentItem: TrieItem? = null
        val index = if (this.value == "") 0 else 1

        for (i in this.children) {
            if (i.value == element[index].toString()) {
                currentItem = i
                break
            }
        }

        return if (currentItem != null) {
            val result = currentItem.minus(element.substring(index))
            if (result) this.size--

            result
        } else false
    }

    fun quantityWithThisPrefix(prefix: String): Int {
        if (prefix == this.value) {
            return this.size
        }

        var currentItem: TrieItem? = null
        val index = if (this.value == "") 0 else 1

        for (i in this.children) {
            if (i.value == prefix[index].toString()) {
                currentItem = i
                break
            }
        }

        return currentItem?.quantityWithThisPrefix(prefix.substring(index)) ?: 0
    }

    fun getAllWords(prefix: String): MutableList<String> {
        val result = if (this.isTerminal) mutableListOf("$prefix${this.value}") else mutableListOf()

        this.children.forEach {
            result.addAll(it.getAllWords("$prefix${this.value}"))
        }

        return result
    }

    fun clear() {
        this.children.clear()
        this.isTerminal = false
        this.size = 0
    }

    fun size(): Int {
        return this.size
    }
}
