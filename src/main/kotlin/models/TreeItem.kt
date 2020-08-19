package models

class TreeItem(val value: String) {

    val children: MutableList<TreeItem> = mutableListOf()
    var isTerminal: Boolean = false
    var size = 0
}